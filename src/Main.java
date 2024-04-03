import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Comparator<Pixel> pixelCompAnon = new Comparator<Pixel>() {
            @Override
            public int compare(Pixel o1, Pixel o2) {
                int v1 = o1.x + o1.y;
                int v2 = o2.x + o2.y;

                if (v1 == v2)
                    return 0;
                if (v1 < v2)
                    return -1;
                return 1;
            }
        };
        Comparator<ColorPixel> colorPixelCompAnon = new Comparator<ColorPixel>() {
            @Override
            public int compare(ColorPixel o1, ColorPixel o2) {
                int v1 = o1.x + o1.y;
                int v2 = o2.x + o2.y;

                if (v1 < v2)
                    return -1;
                if (v1 > v2)
                    return 1;

                if (o1.r == o2.r && o1.g == o2.g && o1.b == o2.b)
                    return 0;

                return -1;
            }
        };

        testSort(pixelCompAnon, colorPixelCompAnon);
        testTreeSet();
    }

    public static void testSort(Comparator<Pixel> comp1, Comparator<ColorPixel> comp2){
        Pixel[] pixels = new Pixel[] {
                new Pixel(100,0), new Pixel(0,100), new Pixel(50,50), new Pixel(25,6),
                new Pixel(30,30), new Pixel(40,20), new Pixel(66,33), new Pixel(1,2),
                new Pixel(40,20), new Pixel(20,40), new Pixel(0,0)
        };
        ColorPixel[] colorPixels = new ColorPixel[] {
                new ColorPixel(10,0,1,1,1), new ColorPixel(6,6,10,10,10), new ColorPixel(0,10,0,0,0),
                new ColorPixel(12,0,3,3,3), new ColorPixel(0,24, 0,0,0), new ColorPixel(1,1,1,1,1)
        };

        System.out.println("Unsorted pixels array:");
        for(Pixel p : pixels){
            System.out.println(p);
        }

        Arrays.sort(pixels, comp1);

        System.out.println("Sorted pixels array:");
        for(Pixel p : pixels){
            System.out.println(p);
        }

        System.out.println("Unsorted colorPixels array:");
        for(Pixel p : colorPixels){
            System.out.println(p);
        }

        Arrays.sort(colorPixels, comp2);

        System.out.println("Sorted colorPixels array:");
        for(Pixel p : colorPixels){
            System.out.println(p);
        }
    }

    public static void testTreeSet(){
        Pixel[] pixels = new Pixel[] {
                new Pixel(100,0), new Pixel(0,100), new Pixel(50,50), new Pixel(25,6),
                new Pixel(30,30), new Pixel(40,20), new Pixel(66,33), new Pixel(1,2),
                new Pixel(40,20), new Pixel(20,40), new Pixel(0,0)
        };
        ColorPixel[] colorPixels = new ColorPixel[] {
                new ColorPixel(10,0,1,1,1), new ColorPixel(6,6,10,10,10), new ColorPixel(0,10,0,0,0),
                new ColorPixel(12,0,3,3,3), new ColorPixel(0,24, 0,0,0), new ColorPixel(1,1,1,1,1)
        };

        TreeSet<Pixel> pixelsSet = new TreeSet<>(new Pixel.PixelComparatorStatic());
        for(Pixel p : pixels){
            pixelsSet.add(p);
        }
        TreeSet<ColorPixel> colorPixelsSet = new TreeSet<>(new ColorPixel.ColorPixelComparatorStatic());
        for(ColorPixel p : colorPixels){
            colorPixelsSet.add(p);
        }

        System.out.println("Pixels set:");
        for(Pixel p : pixelsSet){
            System.out.println(p);
        }

        System.out.println("ColorPixels set:");
        for(ColorPixel p : colorPixelsSet){
            System.out.println(p);
        }
    }
}