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
public class GameNotifier {
   public static final int CARDEVENT_FLIPCARD = 0x01;
    
    public static final int PLAYEREVENT_RECEIVECARD = 0x10;
    public static final int PLAYEREVENT_PLAYCARD = 0x20;
    public static final int PLAYEREVENT_COLLECTCARD = 0x30;
    public static final int PLAYEREVENT_CARDPLAYED = 0x40;
    public static final int PLAYEREVENT_ORDERCHANGED = 0x50;
    public static final int PLAYEREVENT_INFOCHNGED = 0x60;
    public static final int PLAYEREVENT_SCORECHNGED = 0x70;   
    
    public static final int DECKEVENT_ADDCARD = 0x100;
    public static final int DECKEVENT_DISTRIBUTECARD = 0x200;
    public static final int DECKEVENT_ORDERCHANGED = 0x300;
    
    public static final int GAMEEVENT_START  = 0x1000;
    public static final int GAMEEVENT_END   = 0x2000;
    public static final int GAMEEVENT_WIN = 0x80;
    public static final int GAMEEVENT_LOSE = 0x90;
    
    public void fireEvent(int index, ElementClass[] ecs); 
}
