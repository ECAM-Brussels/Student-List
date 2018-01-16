package be.ecam.lur.student;

import android.provider.BaseColumns;

/**
 * Created by lur on 13-03-17.
 */

public class StudentContract {
    public static final class StudentEntry implements BaseColumns {
        public static final String TABLE_NAME = "student";
        public static final String STUDENT_NAME = "name";
        public static final String STUDENT_MATRICULE = "matricule";
        public static final String STUDENT_DIVISION = "division";
    }
}
