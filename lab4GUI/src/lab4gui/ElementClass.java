/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4gui;

/**
 *
 * @author harrietodiete
 */
public class ElementClass {
    protected Object  guiObject;
    protected GameNotifier notifier;
    public void setGUIComponent(Object object){
        guiObject = object;
    }
    public Object getGUIComponent(){
        return guiObject;
    }    
    public void setNotifier(GameNotifier notifier){
        this.notifier = notifier;
    }
    public GameNotifier getNotifier(){
        return notifier;
    }
}
