package zestbloom;

import lombok.Data;

@Data
public class Mail {

    private String account;
    private String url;
    private String subject;
    private String sender;
}