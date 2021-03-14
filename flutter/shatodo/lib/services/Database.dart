import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:shatodo/models/TodoModel.dart';

class Database {
  final FirebaseFirestore firestore;

  Database({this.firestore});

  Stream<List<TodoModel>> streamTodos({String uid}) {
    try {
      return firestore
          .collection("todos")
          .doc(uid)
          .collection("todos")
          .where("done", isEqualTo: false)
          .snapshots()
          .map((event) {
        final List<TodoModel> retValues = <TodoModel>[];
        for (final DocumentSnapshot doc in event.docs) {
          retValues.add(TodoModel.fromDocumentSnapshot(documentSnapshot: doc));
        }
        return retValues;
      });
    } catch (e) {
      rethrow;
    }
  }

  Future<void> addTodo({String uid, String content}) async {
    try {
      firestore.collection("todos").doc(uid).collection("todos").add({
        "content": content,
        "done": false,
      });
    } catch (e) {
      rethrow;
    }
  }

  Future<void> updateTodo({String uid, String todoId}) async {
    try {
      firestore
          .collection("todos")
          .doc(uid)
          .collection("todos")
          .doc(todoId)
          .update({
        "done": true,
      });
    } catch (e) {
      rethrow;
    }
  }
}
