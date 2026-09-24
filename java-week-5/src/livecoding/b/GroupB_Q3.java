package livecoding.b;

import java.util.List;

interface NotificationSender
{
    void send(String message);
}

class EmailSender implements NotificationSender
{
    @Override
    public void send(String message)
    {
        System.out.println("Sending EMAIL: " + message);
    }
}

class SmsSender implements NotificationSender
{
    @Override
    public void send(String message)
    {
        System.out.println("Sending SMS: " + message);
    }
}

class NotificationService
{
    private final List<NotificationSender> senders;

    public NotificationService(List<NotificationSender> senders)
    {
        this.senders = senders;
    }

    public void notifyAllUsers(String message)
    {
        for (NotificationSender sender : senders)
        {
            sender.send(message);
        }
    }
}

public class GroupB_Q3
{
    public static void main(String[] args)
    {
        NotificationSender emailSender = new EmailSender();
        NotificationSender smsSender = new SmsSender();

        NotificationService service = new NotificationService(List.of(emailSender, smsSender));
        service.notifyAllUsers("System update tonight");
    }
}
