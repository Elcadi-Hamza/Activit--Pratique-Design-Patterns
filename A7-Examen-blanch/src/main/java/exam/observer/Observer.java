package exam.observer;

import exam.NetworkState;

public interface Observer {
    void update(NetworkState newState);
}
