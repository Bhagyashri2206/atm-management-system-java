public class User {
    private String userId;
    private String pin;

    public User(String userId, String pin) {
        this.userId = userId;
        this.pin = pin;
    }

    public boolean validate(String id, String pin) {
        return this.userId.equals(id) && this.pin.equals(pin);
    }
}
