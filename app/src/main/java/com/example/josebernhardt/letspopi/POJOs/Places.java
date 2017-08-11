package com.example.josebernhardt.letspopi.POJOs;

import android.widget.ImageView;

/**
 * Created by Jose Bernhardt on 8/10/2017.
 */

public class Places {

  private String name, address, phoneNumber, businnessHours, type;
  private int pic;

  public Places(String name, String address,  String phoneNumber,
      String businnessHours, String type, int pic) {
    this.name = name;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.businnessHours = businnessHours;
    this.type = type;
    this.pic = pic;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getBusinnessHours() {
    return businnessHours;
  }

  public String getType() {
    return type;
  }

  public int getPic() {
    return pic;
  }
}
