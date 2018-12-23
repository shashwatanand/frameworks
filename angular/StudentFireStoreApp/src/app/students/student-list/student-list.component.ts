import { Component, OnInit } from '@angular/core';
import { StudentService } from 'src/app/shared/student.service';
import { Student } from 'src/app/shared/student.model';
import { AngularFirestore } from '@angular/fire/firestore';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  list : Student[];
  constructor(private service : StudentService,
    private fireStore : AngularFirestore,
    private toastr : ToastrService) { }

  ngOnInit() {
    this.service.getStudents().subscribe(actionArray => {
      this.list = actionArray.map(item => {
        return {
          id : item.payload.doc.id,
          ...item.payload.doc.data()
        } as Student
      })
    });
  }

  onEdit(student : Student) {
    this.service.formData = Object.assign({}, student);
  }

  onDelete(id : string) {
    if (confirm("Are you sure to delete this object?")) {
      this.fireStore.doc("students/" + id).delete();
      this.toastr.warning('Deleted successfully', 'Student Registration');
    }
  }
}
