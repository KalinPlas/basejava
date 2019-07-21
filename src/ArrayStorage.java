/**
 * Array based storage for Resumes
 */

import java.util.Arrays;

public class ArrayStorage {

    private Resume[] storage = new Resume[10000];

    private static int elementsCounter = 0;

    void clear() {
        for (int i = 0; i < elementsCounter; i++) {
            storage[i] = null;
        }
        elementsCounter = 0;
    }

    void save(final Resume resume) {
        if (elementsCounter < storage.length) {
            storage[elementsCounter] = resume;
            elementsCounter++;
        } else {
            System.out.println("Storage if full");
        }
    }

    Resume get(final String uuid) {
        for (int i = 0; i < elementsCounter; i++) {
            if (uuid.equals(storage[i].toString())) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(final String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (uuid.equals(storage[i].toString())) {
                storage[i] = null;
                if (i != storage.length - 1) {
                    nullShifter(i);
                }
                elementsCounter--;
                break;
            }
        }
    }

    private void nullShifter(int index) {
        for (int i = index; i < elementsCounter - 1; i++) {
            storage[i] = storage[i + 1];
        }
        storage[elementsCounter - 1] = null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = new Resume[elementsCounter];
        for (int i = 0; i < elementsCounter; i++) {
            resumes[i] = storage[i];
        }
        return resumes;
    }

    int size() {
        return elementsCounter;
    }
}
