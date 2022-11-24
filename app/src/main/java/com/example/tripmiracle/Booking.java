package com.example.tripmiracle;

public class Booking {
        String name, date, duration, time;
        int room;

        public Booking() {
        }

        public Booking(String name, String date, String duration, int room, String time) {
                this.name = name;
                this.date = date;
                this.duration = duration;
                this.room = room;
                this.time = time;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getDate() {
                return date;
        }

        public void setDate(String date) {
                this.date = date;
        }

        public String getDuration() {
                return duration;
        }

        public void setDuration(String duration) {
                this.duration = duration;
        }

        public int getRoom() {
                return room;
        }

        public void setRoom(int room) {
                this.room = room;
        }

        public String getTime() {
                return time;
        }

        public void setTime(String time) {
                this.time = time;
        }
}
