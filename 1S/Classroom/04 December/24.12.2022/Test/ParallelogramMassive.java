public class ParallelogramMassive {
    private Parallelogram[] parallelograms;
    public ParallelogramMassive() {

    }

    public ParallelogramMassive(Parallelogram[] parallelograms) {
        this.parallelograms = parallelograms;
    }

    public double allSquare() {
        if (parallelograms.length < 0) {
            return 0;
        }

        double ans = 0;
        for (int i = 0; i < parallelograms.length; i++) {
            ans += parallelograms[i].square();
        }
        return ans;
    }

    public boolean isTwoEquals() {
        if (parallelograms.length < 2) {
            return false;
        }

        for (int i = 0; i < parallelograms.length; i++) {
            for (int j = i + 1; j < parallelograms.length; i++) {
                if (parallelograms[i].equals(parallelograms[j])) {
                    return true;
                }
            }
        }
        return false;
    }
}
