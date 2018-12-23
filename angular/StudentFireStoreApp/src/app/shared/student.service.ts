import { Injectable } from '@angular/core';
import { Student } from './student.model';
import { AngularFirestore } from '@angular/fire/firestore';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  formData : Student;
  constructor(private fireStore : AngularFirestore) { }

  getStudents() {
    return this.fireStore.collection("students").snapshotChanges();
  }
}
