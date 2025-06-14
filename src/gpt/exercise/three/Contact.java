package gpt.exercise.three;

class Contact {
    private String name;
    private String email;
    private  String phoneNumber;

    Contact(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    String getPhoneNumber() {
        return phoneNumber;
    }

    void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return ("Name: " + this.getName() + "\n"
                + "Email: " + this.getEmail() + "\n"
                + "Phone: " + this.getPhoneNumber()
        );
    }
}
