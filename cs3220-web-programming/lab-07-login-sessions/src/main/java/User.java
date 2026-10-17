public class User {
    // fields
    private String name;
    private String username;
    private String password;

    // constructor
    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    // getters
    public String getName(){return name;}
    public String getUsername(){return username;}
    public String getPassword(){return password;}

    // setters
    public void setName(String newName){this.name = newName;}
    public void setUsername(String newUsername){this.username = newUsername;}
    public void setPassword(String newPassword){this.password = newPassword;}

}
