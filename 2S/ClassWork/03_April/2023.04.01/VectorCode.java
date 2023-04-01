import java.util.Arrays;

public class VectorCode {
    private Elem head;

    private int len;

    public VectorCode(int[] arr) {
        len = arr.length;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                if(head == null) {
                    head = new Elem(i, arr[i]);
                } else {
                    Elem a = new Elem(i, arr[i]);
                    a.setNext(head);

                    head = a;
                }
            }
        }
    }
    public VectorCode() {
        head = null;

        len = 0;
    }
    public int[] decode() {
        int[] ans = new int[len];

        Elem p = head;
        while(p != null) {
            ans[p.getIndex()] = p.getNumber();

            p = p.getNext();
        }
        return ans;
    }

    public void insert(int k, int pos) {
        if(k == 0 || pos < 0 || pos >= len) throw new RuntimeException("Invalid Elem to add");

        Elem p = head;

        Elem lB = head;
        Elem fL = null;

        while(p != null) {
            if(p.getIndex() == pos) {
                break;
            }
            if(p.getIndex() > pos) {
                lB = p;
            }
            if(fL == null && p.getIndex() < pos) {
                fL = p;
            }
            p = p.getNext();
        }

        if(p == null) {
            Elem a = new Elem(pos, k);

            a.setNext(fL);
            lB.setNext(a);

            len++;
        } else {
            p.setNumber(k);
        }
    }

    public void delete(int pos) {
        if(pos < 0 || pos >= len) throw new RuntimeException("Invalid item to delete");

        Elem p = head;
        Elem c = null;
        while(p != null) {
            if(p.getIndex() == pos) {
                break;
            }
            c = p;
            p = p.getNext();
        }

        if(p != null) {
            len --;
            if(c != null) {
                c.setNext(p.getNext());
            }

            p.setNext(null);
        }
    }

    private void add(int pos, int k) {
        Elem a = new Elem(pos, k);
        a.setNext(head);

        head = a;
        len++;
    }

    public int scalarProduct(VectorCode v) {
        int ans = 0;

        Elem p = head;
        Elem c = v.head;
        while(p != null) {
            while(c != null && c.getIndex() > p.getIndex()) {
                c = c.getNext();
            }

            if(c == null) {
                break;
            }

            if (c.getIndex() == p.getIndex()) ans += p.getNumber() * c.getNumber();

            p = p.getNext();
        }

        return ans;
    }

    public VectorCode sum(VectorCode v) {
        VectorCode ans = new VectorCode();
        VectorCode ansB = new VectorCode();

        Elem p = head;
        Elem c = v.head;
        while(p != null) {
            while(c != null && c.getIndex() > p.getIndex()) {
                ansB.add(c.getIndex(), c.getNumber());
                c = c.getNext();
            }

            if(c == null) {
                break;
            }

            if (c.getIndex() == p.getIndex()) {
                ansB.add(p.getIndex(), p.getNumber() + c.getNumber());
            } else {
                ansB.add(p.getIndex(), p.getNumber());
            }

            p = p.getNext();
        }

        while(c != null) {
            ansB.add(c.getIndex(), c.getNumber());
            c = c.getNext();
        }

        p = ansB.head;
        while(p != null) {
            ans.add(p.getIndex(), p.getNumber());

            p = p.getNext();
        }

        return ans;
    }


    public VectorCode vectorSum() {
        VectorCode ans = new VectorCode();
        VectorCode ansB = new VectorCode();

        int sum = 0;
        Elem p = head;
        while(p != null) {
            sum += p.getNumber();

            p = p.getNext();
        }

        p = head;
        while(p != null) {
            ansB.add(p.getIndex(), sum);

            sum -= p.getNumber();

            p = p.getNext();
        }

        p = ansB.head;
        while(p != null) {
            ans.add(p.getIndex(), p.getNumber());

            p = p.getNext();
        }

        return ans;
    }
}
