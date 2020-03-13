import 'package:flutter/material.dart';

void main() => runApp(
      MaterialApp(
        home: Scaffold(
          backgroundColor: Colors.blueGrey[900],
          appBar: AppBar(
            backgroundColor: Colors.indigo[300],
            title: Text('I am poor'),
          ),
          body: Center(
            child: Image.asset('images/i_am_poor.png'),
          ),
        ),
      ),
    );
