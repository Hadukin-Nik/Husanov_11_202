public class ElemQueue {
    private Elem head;
    private Elem end;

    private int size;

    public ElemQueue(Elem first) {
        head = first;
        end = first;

        size = 1;
    }

    public Elem getHead() {
        return head;
    }

    public void print() {
        Elem p = head;
        while(p != null) {
            System.out.println(p.getValue());

            p = p.getPrevious();
        }
    }

    public ElemQueue push(Elem add) {
        end.setPrevious(add);
        add.setForward(end);
        end = add;

        size++;

        return this;
    }



    public Elem poll() {
        Elem ans = head;
        head = head.getPrevious();
        head.setForward(null);
        size--;

        if (size < 0) {
            size = 0;
        }

        return ans;
    }

    public int findMax() {
        Elem p = head;
        int max = 0;
        while(p != null) {
            if (p.getValue() >= max) {
                max = p.getValue();
            }

            p = p.getPrevious();
        }

        return max;
    }

    public boolean isContains(int toFind) {
        Elem p = head;
        while(p != null) {
            if (p.getValue() == toFind) {
                return true;
            }

            p = p.getPrevious();
        }

        return false;
    }

    public void sort() {
        for (int i =0; i < size; i++) {
            Elem p = head;
            while(p.getPrevious() != null) {
                if (p.getValue() > p.getPrevious().getValue()) {
                    Elem b = p.getPrevious();
                    p.setPrevious(b.getPrevious());
                    if (b.getPrevious() != null) {
                        b.getPrevious().setForward(p);
                    }
                    b.setPrevious(p);
                    b.setForward(p.getForward());

                    if(p.getForward() != null) {
                        p.getForward().setPrevious(b);

                    }
                    p.setForward(b);
                    if (b.getForward() == null){
                        head = b;
                    }
                    p = b;
                } else {
                    p = p.getPrevious();
                }

            }
        }
    }

    public Elem findFirst(int a) {
        Elem p = head;

        while(p != null) {
            if (p.getValue() == a) {
                return p;
            }

            p = p.getPrevious();
        }

        return null;
    }

    public Elem findLast(int a) {
        Elem p = head;
        Elem ans = null;
        while(p != null) {
            if (p.getValue() == a) {
                ans = p;
            }

            p = p.getPrevious();
        }

        return ans;
    }

    public void insertAfter(Elem before, Elem insertable) {
        insertable.setPrevious(before.getPrevious());
        if (before.getPrevious() != null) {
            before.getPrevious().setForward(insertable);
        }
        before.setPrevious(insertable);
        insertable.setForward(before);
    }

    public void insertBefore(Elem after, Elem insertable) {
        if (after.getForward() != null) {
            insertAfter(after.getForward(), insertable);
        } else {
            insertable.setPrevious(after);
            after.setForward(insertable);
        }
    }

    public void delete(int count) {
        if (count <= size) {
            Elem p = head;

            while(p != null) {
                if (count == 0) {
                    head = p;
                    p.setForward(null);

                    return;
                }

                p = p.getPrevious();
                count --;
            }
        }
    }

    public void delete(Elem elem) {
        if (elem.getForward() != null && elem.getPrevious() != null) {
            elem.getForward().setPrevious(elem.getPrevious());
            elem.getPrevious().setForward(elem.getForward());
        } else if (elem.getForward() != null) {
            end = elem.getForward();
            elem.getForward().setPrevious(null);
        } else if (elem.getPrevious() != null){
            head = elem.getPrevious();
            elem.getPrevious().setForward(null);

        }
    }

    //----TASKS

    //1
    public void deleteTwoFirst() {
        delete(2);
    }

    //2
    public void deleteFirstMention(int a) {
        delete(findFirst(a));
    }

    //3
    public void deleteAll(int a){
        while(findFirst(a) != null) {
            deleteFirstMention(a);
        }
    }

    //4
    public void insertAfterFirstMention(int a, Elem b) {
        insertAfter(findFirst(a), b);
    }

    //5
    public void insertBeforeFirstMention(int a, Elem b) {
        insertBefore(findFirst(a), b);
    }

    //6
    public void insertAfterAll(int a, Elem b) {
        insertAfter(findLast(a), b);
    }
}
