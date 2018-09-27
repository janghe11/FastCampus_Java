package net.thjang.blog;

// 답을 봐버림!!
public class Q3 {
    private int max;
    private int ptr1;
    private int ptr2;
    private int[] stk;

    public enum Stacks {
        Stack1, Stack2
    };

    public class EmptyIntStackX2Exception extends RuntimeException {
        public EmptyIntStackX2Exception() {
        }
    }

    public class OverflowIntStackX2Exception extends RuntimeException {
        public OverflowIntStackX2Exception() {
        }
    }

    public Q3(int capacity) {
        ptr1 = 0;
        ptr2 = capacity - 1;
        max = capacity;
        try {
            stk = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int push(Stacks sw, int x) throws OverflowIntStackX2Exception {
        if (ptr1 >= ptr2 + 1)
            throw new OverflowIntStackX2Exception();
        switch (sw) {
            case Stack1:
                stk[ptr1++] = x;
                break;
            case Stack2:
                stk[ptr2--] = x;
                break;
        }
        return x;
    }

    public int pop(Stacks sw) throws EmptyIntStackX2Exception {
        int x = 0;
        switch (sw) {
            case Stack1:
                if (ptr1 <= 0)
                    throw new EmptyIntStackX2Exception();
                x = stk[--ptr1];
                break;
            case Stack2:
                if (ptr2 >= max - 1)
                    throw new EmptyIntStackX2Exception();
                x = stk[++ptr2];
                break;
        }
        return x;
    }

    // 스택에서 데이터를 피크(꼭대기의 데이터를 살펴 봄)
    public int peek(Stacks sw) throws EmptyIntStackX2Exception {
        int x = 0;
        switch (sw) {
            case Stack1:
                if (ptr1 <= 0) // 스택 A가 비어 있음
                    throw new EmptyIntStackX2Exception();
                x = stk[ptr1 - 1];
                break;
            case Stack2:
                if (ptr2 >= max - 1) // 스택 B가 비어 있음
                    throw new EmptyIntStackX2Exception();
                x = stk[ptr2 + 1];
                break;
        }
        return x;
    }

    // 스택에서 x를 검색하여 index(찾지 못하면 -1)를 반환
    public int indexOf(Stacks sw, int x) {
        switch (sw) {
            case Stack1:
                for (int i = ptr1 - 1; i >= 0; i--) // 꼭대기쪽부터 선형 검색
                    if (stk[i] == x)
                        return i; // 검색성공
                break;
            case Stack2:
                for (int i = ptr2 + 1; i < max; i++) // 꼭대기쪽부터 선형 검색
                    if (stk[i] == x)
                        return i; // 검색성공
                break;
        }
        return -1; // 검색실패
    }

    // 스택을 비움
    public void clear(Stacks sw) {
        switch (sw) {
            case Stack1:
                ptr1 = 0;
                break;
            case Stack2:
                ptr2 = max - 1;
                break;
        }
    }

    public int capacity() {
        return max;
    }

    // 스택에 쌓여있는 데이터 수를 반환
    public int size(Stacks sw) {
        switch (sw) {
            case Stack1:
                return ptr1;
            case Stack2:
                return max - ptr2 - 1;
        }
        return 0;
    }

    // 스택이 비어 있는가?
    public boolean isEmpty(Stacks sw) {
        switch (sw) {
            case Stack1:
                return ptr1 <= 0;
            case Stack2:
                return ptr2 >= max - 1;
        }
        return true;
    }

    // 스택이 가득 찼는가?
    public boolean isFull() {
        return ptr1 >= ptr2 + 1;
    }

    // 스택 안의 터이터를 바닥 → 꼭대기의 차례로 나타냄
    public void dump(Stacks sw) {
        switch (sw) {
            case Stack1:
                if (ptr1 <= 0)
                    System.out.println("스택이 비었습니다.");
                else {
                    for (int i = 0; i < ptr1; i++)
                        System.out.print(stk[i] + " ");
                    System.out.println();
                }
                break;
            case Stack2:
                if (ptr2 >= max - 1)
                    System.out.println("스택이 비었습니다.");
                else {
                    for (int i = max - 1; i > ptr2; i--)
                        System.out.print(stk[i] + " ");
                    System.out.println();
                }
                break;
        }
    }
}
