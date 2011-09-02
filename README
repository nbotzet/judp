Java UDP
========

This library provides a helpful abstraction over Java's built in UDP handling.


Usage
--------

Create a 
     JUDP judp =  new JUDP();
and initialize it with
     judp.start(inetAdress, serverport, clientport);
where inetAdress is the IP adress of the server you want to talk to,
serverport is the port you wand to send to,
and clientport is the port you want to listen on.

Use 
     judp.receive()
to get an incoming package (best used in a running loop)
and 
     judp.send(message)
to send the String "message" to the server.