import time
from multiprocessing.connection import Listener
from multiprocessing.connection import Client
from array import array

import json
import thread
import sys


serverAddress = ('localhost', 6000)
conn = Client(serverAddress, authkey='hello')
conn.send('handshake')

print "Handshake Done"  # handshake

myAddress = ('localhost', 6001)     # family is deduced to be 'AF_INET'
listener = Listener(myAddress, authkey='hello')
conn2 = listener.accept()
print "the server has connected to me"


def printDataRecievedFromServer():
	while True:
		msg = conn2.recv()
		print msg[:-1] #as last char is \n


thread.start_new_thread( printDataRecievedFromServer  , () )

def sendReq(command , name , content=''):
	q = {'command':command , 'name' :name , 'content':content }
	q = json.dumps(q)

	global conn
	conn.send(q)




commands = sys.argv
name = commands[2]

if commands[1] == 'new':
	print sendReq('new' , name )


sendReq('sendCommand' , name )


while True:
	c = raw_input("")
	sendReq('sendCommand' , name , c)




