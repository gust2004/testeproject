package br.com.testeproject.domain;


import br.com.testeproject.util.EncryptationUtil;
import br.com.testeproject.util.JSONUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "_USER_")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private Integer id;

    @Column(name = "USER_NAME", nullable = false, length = 80)

    private String name;
    @Column(name = "USER_EMAIL", nullable = true, length = 100)
    private String email;
    @Column(name = "USER_LOGIN", nullable = false, length = 100)
    private String login;
    @Column(name = "USER_PASSWORD", nullable = false, length = 32)
    private String password;
  
    public User() {
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", this.getId());
        map.put("name", this.getName() != null && !this.getName().equals("") ? this.getName() : "");
        map.put("email", this.getEmail() != null && !this.getEmail().equals("") ? this.getEmail() : "");
        map.put("login", this.getLogin() != null && !this.getLogin().equals("") ? this.getLogin() : "");
       
        return map;
    }

    public String toJson() {
        return JSONUtil.mapToJSON(this.toMap());
    }

    public static String toJsonList(List<User> users, Integer total, Integer totalList) {
        String json = "{\"guests\":[";
        int cont = 0;
        if (users != null) {
            for (User user : users) {
                json += user.toJson();
                if (cont < users.size() - 1) {
                    json += ",";
                }
                cont++;
            }
        }
        json += "]";
        json += (",\"totalList\":" + totalList);
        json += (",\"total\":" + total + "}");
        return json;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = EncryptationUtil.encrypt(password);
    }

    
}
