/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4gui;
import java.awt.*;
/**
 *
 * @author harrietodiete
 */
public class CardLayout implements LayoutManager{
    
    public static final int    DEFAULT_CMP_WIDTH = 72;
    public static final int    DEFAULT_CMP_HEIGHT = 96;
    
    public static final int DEFUALT_MARGIN = 15;
    public enum ORIENTATION {ORIENTATION_VERTICAL,ORIENTATION_HORIZONTAL};
    private ORIENTATION  orientation;//={ORIENTATION_VERTICAL,ORIENTATION_HORIZONTAL} 
    private int seperation = DEFUALT_MARGIN;

    public CardLayout() {
        this(ORIENTATION.ORIENTATION_HORIZONTAL, DEFUALT_MARGIN);
    }
    public CardLayout(ORIENTATION Orientation, int sep) {
        this.orientation = Orientation;
        seperation = sep;
    }

    public void setSeperation(int s) {
        seperation = s;
    }

    public int getSeperation() {
        return seperation;
    }

    /* Required by LayoutManager. */
    public void addLayoutComponent(String name, Component comp) {
    }

    /* Required by LayoutManager. */
    public void removeLayoutComponent(Component comp) {
    }

    /* Required by LayoutManager. */
    public Dimension minimumLayoutSize(Container parent) {
        //set predefined current defaults. Doesn't check for edges of container
        return preferredLayoutSize(parent);
    }

    /* Required by LayoutManager. */
    public Dimension preferredLayoutSize(Container parent) {
        //set predefined current defaults. Doesn't check for edges of container
        Dimension dim = new Dimension(0, 0);
        int iLastVisible = 0;
        int marginTotal = 0;
        
        for(int i =0; i< parent.getComponents().length; i++){
            Component c = parent.getComponent(i);
            if(parent.getComponent(i).isVisible()){
                iLastVisible = i;
                marginTotal += seperation;
            }
        }
        
        if(marginTotal>0){
            if(orientation == ORIENTATION.ORIENTATION_VERTICAL){
                dim.height = marginTotal + DEFAULT_CMP_HEIGHT - seperation;
                dim.width = DEFAULT_CMP_WIDTH;
            }
            else{
                dim.width = marginTotal + DEFAULT_CMP_WIDTH - seperation;                    
                dim.height = DEFAULT_CMP_HEIGHT;
            }
        }
        return dim;
    }
    /* Required by LayoutManager. */
    /*
     * This is called when the panel is first displayed,
     * and every time its size changes.
     * Note: You CAN'T assume preferredLayoutSize or
     * minimumLayoutSize will be called -- in the case
     * of applets, at least, they probably won't be.

     */
    public void layoutContainer(Container parent) {
        int nComps = parent.getComponentCount();
        Dimension dim = preferredLayoutSize(parent);
        int xStart = (parent.getWidth() - dim.width)/2;
        int yStart = (parent.getHeight() - dim.height)/2;
        int xSeperation = (orientation == ORIENTATION.ORIENTATION_HORIZONTAL)?seperation:0;
        int ySeperation = (orientation == ORIENTATION.ORIENTATION_VERTICAL)?seperation:0;
        
        for (int i = 0; i < nComps; i++) {
            Component c = parent.getComponent(i);
            
            if (c.isVisible()){
                c.setSize(DEFAULT_CMP_WIDTH,DEFAULT_CMP_HEIGHT);
                Point newLoc = new Point(xStart+xSeperation*(nComps-i-1), yStart + ySeperation*(nComps-i-1));
                //cards are listed in reverse order, right2left, bottom2top for proper gui rendering 
                c.setLocation(newLoc);
                //c.setBounds(xStart+xSeperation*i, yStart + ySeperation*i,c.getWidth(),c.getHeight());
            }
        }
    }
}
