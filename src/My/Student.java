package My;

import java.util.ArrayList;

public class Student {
    private ArrayList<Student> friends = new ArrayList<Student>();

    public synchronized ArrayList<Student> getFriends() {
        synchronized (friends) {
            return new ArrayList(friends);
        }
    }

    public synchronized int getFriendsCount() {
        return friends.size();
    }

    public int addFriend(Student student) {
        synchronized (friends) {
            friends.add(student);
            return getFriendsCount();
        }
    }
}
