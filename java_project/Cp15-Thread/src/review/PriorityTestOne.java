package review;

class PriorityTestOne
{
public static void main(String[] args)
{
MessageSendingThread tr1=new MessageSendingThread("First",1);
MessageSendingThread tr2=new MessageSendingThread("Second",1);
MessageSendingThread tr3=new MessageSendingThread("Third",1);
tr1.start();
tr2.start();
tr3.start();
}
}