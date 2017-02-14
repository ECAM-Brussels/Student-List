package be.ecam.lur.student;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lur on 05-02-17.
 */

public class Student {
    private String name = null;
    private String matricule = null;
    private String division = null;
    private static String[] divisions = {"1BA", "2BA", "3BM", "3BE", "3BC", "4MEM", "5MEM", "4MAU", "5MAU", "4MCO", "5MCO", "4MGE", "5MGE", "4MIN", "5MIN", "4MEO", "5MEO"};

    private static ArrayList<Student> students = new ArrayList<>();

    public static void parse(String json) throws JSONException {
        Log.i("Student", "beginning Parsing");
        students.clear();
        JSONArray jsonStudents = new JSONArray(json);

        for (int i=0; i<jsonStudents.length(); i++) {
            JSONObject jsonStudent = jsonStudents.getJSONObject(i);
            String nameAndDivision = jsonStudent.getString("npetu");
            String matricule = jsonStudent.getString("matetu");

            if(nameAndDivision.length() != 0 && !nameAndDivision.startsWith("Etudiant"))
                students.add(fixStudent(nameAndDivision, matricule));
        }
    }

    Student(String name, String matricule, String division) {
        this.name = name;
        this.matricule = matricule;
        this.division = division;
    }

    private static Student fixStudent(String nameAndDivision, String matricule) {
        for (String suffix: divisions) {
            if(nameAndDivision.endsWith(suffix)) {
                return new Student(nameAndDivision.substring(0, nameAndDivision.length() - suffix.length()), matricule, suffix);
            }
        }
        return new Student(nameAndDivision, matricule, "");
    }

    public static String[] getNames() {
        String[] names = new String[students.size()];
        for (int i=0; i<students.size(); i++) {
            names[i] = students.get(i).name;
        }

        return names;
    }

    public static Student find(int index) {
        return students.get(index);
    }

    public String getName() {
        return name;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getDivision() {
        return division;
    }

    public static int count() {
        return students.size();
    }
}
