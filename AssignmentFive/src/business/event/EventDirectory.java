/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.event;

import java.util.ArrayList;

/**
 *
 * @author aravindpolepeddi
 */
public class EventDirectory {

    private ArrayList<Event> eventList;

    public ArrayList<Event> getEventList() {
        return eventList;
    }

    public void setEventList(ArrayList<Event> event) {
        if(eventList==null)
            eventList=new ArrayList<Event>();
        this.eventList = event;
    }

    public Event findEvent(String Name){
    for(Event eve:eventList){
    if(eve.getEventName().equals(Name)){
    return eve;
    }
    }
    return null;
    }

        public boolean checkIfEventnameIsUnique(String eventname) {
        if(eventList==null){
            eventList=new ArrayList<Event>();
                  return true;
        }
        for (Event eve : eventList) {
            if (eve.getEventName().equals(eventname)) {
                return false;
            }
        }
        return true;
    }

        public void createEvent(Event eve){
        eventList.add(eve);
    }

}