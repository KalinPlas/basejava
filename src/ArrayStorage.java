/**
 * Array based storage for Resumes
 */

import java.util.Arrays;

public class ArrayStorage {

    private Resume[] storage = new Resume[10000];

    private static int elementsCounter = 0;

    void clear() {
        Arrays.fill(storage, null);
        elementsCounter = 0;
    }

    void save(final Resume resume) {
        if (elementsCounter < 10000) {
            storage[elementsCounter] = resume;
            elementsCounter++;
        } else System.out.println("Storage if full");
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
        for (int i = 0; i < elementsCounter; i++) {
            if (uuid.equals(storage[i].toString())) {
                storage[i] = null;
                if (i != storage.length) {
                    nullShifter(i);
                }
                elementsCounter--;
                i = elementsCounter;
            }
        }
    }

    private void nullShifter(int index) {
        for (int i = index; i < elementsCounter; i++) {
            storage[i] = storage[i + 1];
            storage[i + 1] = null;
        }
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
