package gen.jdbc;
class Rectangle{
    double length,width;
    Rectangle()
    {
        length=0;
        width=0;
    }
    public void setrect(double length,double width)
    {
        this.length=length;
        this.width=width;
    }
    public double area()
    {
        return length*width;
    }
}
class Box extends Rectangle{
    double height;
    Box()
    {
        height=0;
    }
    void setBox(double length,double width,double height)
    {
        setrect(length,width);
        this.height=height;
    }
    double volume()
    {
        return height*area();
    }
}
class Rec_Cic {
    public static void main(String[] args) {
        System.out.println("Box and Rectangle");
        Box b=new Box();
        b.setBox(10,20,30);
        System.out.println(b.volume());
        
    }
}