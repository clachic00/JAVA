package review;

class MessageSendingThread extends Thread
{
String message;
int priority;
public MessageSendingThread(String str,int prio)
{
message=str;
setPriority(prio);
}

public void run()
{
for(int i=0; i<1000000; i++)
System.out.println(message+"("+getPriority()+")");
}
}


