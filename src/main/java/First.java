public class First {
    private int A;
    private int f;
    private double fi;
    private int N;
    private final Variable[] variables = {
//            new Variable(3, 1, Math.PI / 4),
//            new Variable(3, 2, Math.PI * 3 / 4),
//            new Variable(3, 3, Math.PI * 2 / 3),
//            new Variable(3, 4, Math.PI / 2),
//            new Variable(3, 5, Math.PI / 3)};

//            new Variable(1, 1, 0),
//            new Variable(1, 2, Math.PI / 4),
//            new Variable(1, 3, Math.PI  / 6),
//            new Variable(1, 4, Math.PI *2),
//            new Variable(1, 5, Math.PI )};
//
//            new Variable(5, 1, Math.PI / 9),
//            new Variable(5, 2, Math.PI / 4),
//            new Variable(5, 3, Math.PI  / 3),
//            new Variable(5, 4, Math.PI /6),
//            new Variable(5, 5, 0 )};


            new Variable(7, 1, Math.PI ),
            new Variable(7, 2, Math.PI / 4),
            new Variable(7, 3, 0),
            new Variable(7, 4, Math.PI * 3 /4),
            new Variable(7, 5, Math.PI / 2)};

    public double getN() {
        return N;
    }

    public void setA(int a) {
        A = a;
    }

    public void setF(int f) {
        this.f = f;
    }

    public void setFi(int fi) {
        this.fi = fi;
    }

    public First(int N) {
        this.N = N;

    }

    public double calculate_Afi(double fi, int n) {
        double res = A * Math.sin(2 * Math.PI * f * n / N + fi);
        return res;
    }

    public double calculate_Af(int f, int n) {
        double res = A * Math.sin(2 * Math.PI * f * n / N + fi);
        return res;
    }

    public double calculate_ffi(int A, int n) {
        double res = A * Math.sin(2 * Math.PI * f * n / N + fi);
        return res;
    }

    public double calculatePolyharmonic(int n) {
        double res = 0;
        for (int i = 0; i < 5; i++) {
            res += sumPolyharmonic(variables[i].getA(), variables[i].getF(), variables[i].getFi(), n);
        }
        return res;
    }

    public double sumPolyharmonic(int A, int f, double fi, int n) {
        double res = A * Math.sin(2 * Math.PI * f * n / N + fi);
        return res;
    }
}
