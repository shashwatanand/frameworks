import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {AngularFireModule} from '@angular/fire';
import {AngularFirestoreModule} from '@angular/fire/firestore'

import { AppComponent } from './app.component';
import { environment } from 'src/environments/environment';
import { StudentsComponent } from './students/students.component';
import { StudentComponent } from './students/student/student.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentsComponent,
    StudentComponent
  ],
  imports: [
    BrowserModule,
    AngularFireModule.initializeApp(environment.firebaseConfig),
    AngularFirestoreModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
