package review;

class PriorityTestTwo
{
public static void main(String[] args)
{
MessageSendingThread tr1
=new MessageSendingThread("First", Thread.MAX_PRIORITY);
MessageSendingThread tr2
=new MessageSendingThread("Second", Thread.NORM_PRIORITY);
MessageSendingThread tr3
=new MessageSendingThread("Third", Thread.MIN_PRIORITY);
tr1.start();
tr2.start();
tr3.start();
}
}