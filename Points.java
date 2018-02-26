class Points {
    private float points[][]; // Array, which contains certain number of points {x1, x2}
    private byte type[]; // Array, which contains types of points

    Points(int amount) {
        points = new float[amount][2];
        type = new byte[amount];

        for (int i = 0; i < points.length; i++) {
            points[i][0] = (float)Math.random();
            points[i][1] = (float)Math.random();

            if(points[i][1] > linearFunction(points[i][0])) // Points under y = (-x) + 1 line 
                type[i] = 1;                                // are type 1, others are type (-1)
            else
                type[i] = (-1);
        }
    }

    public int getLength() {
        return points.length;
    }

    public float getX1(int ordinalNumber) {
        return points[ordinalNumber][0];
    }

    public float getX2(int ordinalNumber) {
        return points[ordinalNumber][1];
    }

    public int getType(int ordinalNumber) {
        return (int)(type[ordinalNumber]);
    }

    //y = kx + b
    private float linearFunction(float x) {
        return ((-1) * x + 1);
    }
}