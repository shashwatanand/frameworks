import { Component, OnInit } from '@angular/core';
import { StudentService } from 'src/app/shared/student.service';
import { NgForm } from '@angular/forms';
import { AngularFirestore } from '@angular/fire/firestore';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  constructor(private service : StudentService,
    private fireStore : AngularFirestore,
    private toastr : ToastrService) { }

  ngOnInit() {
    this.resetForm();
  }

  resetForm(form? : NgForm) {
    if (form != null) {
      form.resetForm();
    }
    this.service.formData = {
      id : null,
      studentId : "",
      fullName : "",
      dept : "",
      mobile : ""
    }
  }

  onSubmit(form:NgForm) {
    let data = form.value;
    this.fireStore.collection('students').add(data);
    this.resetForm(form);
    this.toastr.success("Submitted successfully", "Student Registration");
  }

}
