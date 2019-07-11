/**
 * Array based storage for Resumes
 */

import java.util.ArrayList;

public class ArrayStorage {

    //Resume[] storage = new Resume[10000];
    // let's use optimal variant for this - ArrayList ( That's no cheating =) )

    private ArrayList<Resume> storage = new ArrayList<>();

    void clear() { storage.clear(); }

    void save(final Resume r) { storage.add(r); }

    Resume get(final String uuid) { // return resume by iterating over items and compares their uuids

    String comparableUuid;
    Resume resume;

    for(int i = 0;i < size();i++) {

            resume = storage.get(i);
            comparableUuid = resume.uuid;
            if(comparableUuid.equals(uuid)) return storage.get(i);
    }
        return null;
    }

    void delete(final String uuid) { // delete resume by iterating over items and compares their uuids

        String comparableUuid;
        Resume resume;

        for(int i = 0;i < size();i++) {

            resume = storage.get(i);
            comparableUuid = resume.uuid;
            if(comparableUuid.equals(uuid)) storage.remove(i);
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = storage.toArray(new Resume[0]);
        return resumes;
    }

    int size() { return storage.size(); }
}
