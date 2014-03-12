 package com.example.aidl;

 interface IMusicService {
   void play();
   void pause();
   void stop();
   void onDestroy();
 }