package SplitWise;

abstract class Split {
    private User user;

    public Split(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
