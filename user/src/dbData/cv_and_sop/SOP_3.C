/*

Hello we present the worlds most flexible and the most optimized LCD c library for avr c

// all the commands will be only one operation ... unlike other libraries the the exact port masks will be preprocessed by the compiler.

// to make it flexixible we need the compiler need to convert the raw command hex code to a avr port mappings
// for that we are transfroming the 4 bit binary vector to aan 8 bit vector.

*/

// #todo -- shange the delay values

#include <avr/io.h>
#include <util/delay.h>

#define F_CPU 16000000UL


// configration of the data pins
#define DATA_PORT PORTD
#define DATA_PORT_DDR DDRD

#define D4_BIT PORTD5
#define D5_BIT PORTD4
#define D6_BIT PORTD3
#define D7_BIT PORTD2

#define E_PORT PORTB
#define E_BIT PORTB3
#define E_PORT_DDR DDRB
#define RS_PORT PORTB
#define RS_BIT PORTB4
#define RS_PORT_DDR DDRB


#define DDR_MASK  ( (1<<D4_BIT) | (1<<D5_BIT) | (1<<D6_BIT) | (1<<D7_BIT) )// to set the 4 bits as output at once

// set pinmode as output for the given LCD pins
#define SET_PINS_MODE();\
	E_PORT_DDR |= (1<<E_BIT);\
	RS_PORT_DDR |= (1<<RS_BIT);\
	DATA_PORT_DDR |= DDR_MASK;\


#define ENABLE_HIGH()  ( E_PORT |=  ( 1 << E_BIT ))  
#define ENABLE_LOW()  ( E_PORT &=  ~( 1 << E_BIT ))
#define RS_HIGH()  ( RS_PORT |=  ( 1 << RS_BIT ))
#define RS_LOW()  ( RS_PORT &=  ~( 1 << RS_BIT ))

#define LCD_MODE_DATA() RS_HIGH()  // to set the mode of the lcd to take charecters etc
#define LCD_MODE_COMMAND()  RS_LOW()  // to set the mode of the lcd to take instructions

// preproccessed function to convert the lcd date vector to the avr port vector
#define LCD_COMMAND_2_PORT_DATA( command ) ( (((command & 1<<7)>>7) << D7_BIT) | (((command & 1<<6)>>6) << D6_BIT) | (((command & 1<<5)>>5) << D5_BIT) | (((command & 1<<4)>>4) << D4_BIT)   )

// function to set the pins to zero
#define SET_TO_ZERO()  (DATA_PORT &= ~DDR_MASK )

// function to send a command to the lcd just 4 bits
#define WRITE_COMMAND_4bit(command)  (  DATA_PORT |= LCD_COMMAND_2_PORT_DATA((command >>4)<<4) )


// some commands
#define LCD_CLEAR_RAW 0b00000001
#define LCD_DISPLAY_OFF  0b00001000          // turn display off
#define LCD_DEISPLAY_ON  0b00001100          // display on, cursor off, don't blink character
#define LCD_RESET_RAW   0b00110000          // reset the LCD
#define LCD_SET_FONT_BIT_SIZE_RAW 0b00101000          // 4-bit data, 2-line display, 5 x 7 font

// #todo convert binary to hex

inline void clearLCD() // clear the lcd
{
	sendCommand(LCD_CLEAR_RAW);
	_delay_ms(4);
}

inline void displayOn() // set the display on
{
	sendCommand(LCD_DEISPLAY_ON);
	_delay_ms(4);
}

inline void displayOff() // set the display off
{
	sendCommand(LCD_DISPLAY_OFF);
	_delay_ms(4);
}

void pulseEnable() {  // to send a clock pulse to enable
	ENABLE_LOW();
	_delay_us(1);
	ENABLE_HIGH();
	_delay_us(1);  // enable pulse must be >450ns
	ENABLE_LOW();
	_delay_us(100);    // commands need > 37us to settle
}

void send4BitData(uint8_t command) // send first 4 bits of the bbit data
{
	SET_TO_ZERO();
	WRITE_COMMAND_4bit( command );
	pulseEnable();
}

inline void send8bitData(uint8_t command) // send 8 bit data one by one
{
	send4BitData(command);
	send4BitData(command << 4);
}


void sendString(uint8_t theString[])
{
	LCD_MODE_DATA();
	int i = 0;                             // character counter*/
	while (theString[i] != 0)
	{
		send8bitData(theString[i]);
		i++;
		_delay_us(80);                              // 40 uS delay (min)
	}
}
// #todo --- edit the above function

void sendCommand(uint8_t command)
{
	LCD_MODE_COMMAND();
	send8bitData(command);
}

void initLCD()
{
	SET_PINS_MODE();
	_delay_ms(100);  // wait for lcd to power up
	
	RS_LOW();
	ENABLE_LOW();
	
	send4BitData(LCD_RESET_RAW);
	_delay_ms(10);
	
	send4BitData(LCD_RESET_RAW);
	_delay_us(200);
	
	send4BitData(LCD_RESET_RAW);
	_delay_us(200);
	
	send4BitData(LCD_SET_FONT_BIT_SIZE_RAW);
	_delay_us(80);
	
	sendCommand(LCD_SET_FONT_BIT_SIZE_RAW);
	_delay_us(80);
	
	
	displayOff();
	
	clearLCD();
	
	displayOn();
	
	// #todo - why we do display on n off ?

}


/******************************* Main Program Code *************************/
void setup()
{
	initLCD();
	
	while(1)
	{
		uint8_t divam[]   = "Aishwarya";
		uint8_t aishwarya[]   = "Divam";
		sendString( divam );
		_delay_ms( 2000 );
		clearLCD();
		
		sendString( aishwarya);
		_delay_ms( 2000 );
		clearLCD();
	}

}


