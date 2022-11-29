package ru.kpfu.longArithmetics;

public class Number {
	private final int MAX_SIZE = 100000;

	private int[] longNum;

	private int sign;

	public Number() {
		longNum = new int[MAX_SIZE];

		sign = 1;
	}

	public Number(int size) {
		longNum = new int[size];

		sign = 1;
	}

	public Number(int[] number, int sign) {
		longNum = number;

		this.sign = sign;
	}

	public Number add(Number other) {
		int max_size = 0;
		int min_size = 0;


		int[] source = longNum;
		int[] addable = other.getNum();

		int answerSign = 1;

		if (other.getSign() * sign < 0) {
			if (other.getSign() < 0) {
				sub(new Number(other.getNum(), 1));
			} else {
				other.sub(new Number(other.getNum(), 1));
			}
		}

		if (sign < 0) {
			answerSign = -1;
		}

		if (isBigger(other)) {
			max_size = source.length;
			min_size = addable.length;
		} else {
			max_size = addable.length;
			min_size = source.length;

			int[] buffer = source;
			source = addable;
			addable = buffer;
		}

		max_size ++;

		int[] buffer = new int[max_size];

		for (int i = 0; i < max_size; i++) {
			if (i < min_size) {
				buffer[i] = source[i] + addable[i];
			} else {
				buffer[i] = source[i];
			}

			if (buffer[i] > 9) {
				buffer[i + 1] += buffer[i] / 10;
				buffer[i] %= 10;
			}
		} 

		if (buffer[max_size - 1] == 0) {
			int[] answer = new int[max_size - 1];

			for (int i = 0; i < max_size - 1; i++) {
				answer[i] = buffer[i];
			}

			return new Number(answer, answerSign);
		} else {
			return new Number(buffer, answerSign);
		}
	}

	public Number sub(Number other)  {
		if (sign * other.getSign() < 0) {
			return add(other);
		}

		if (sign < -1) {
			return other.sub(new Number(longNum, other.getSign()));
		}

		int ansSign = 1;


		int[] source = longNum;
		int[] addable = other.getNum();


		if (!isBigger(other)) {
			ansSign = -1;

			int[] buffer = source;
			source = addable;
			addable = source;
		}
		System.out.println(source + " " + addable);
		
		int max_size = source.length;
		int min_size = addable.length;

		int[] preBuffer = source;

		source = new int[max_size];
		for (int i =0; i < max_size; i++) {
			source[i] = preBuffer[i];
		}

		min_size = addable.length;

		int[] buffer = new int[max_size];

		for (int i = 0; i < min_size; i++) {
			if (source[i] >= addable[i]) {
				buffer[i] = source[i] - addable[i];
			} else {
				int j = i + 1;
				while (j < max_size) {
					if (source[i] > 0) {
						source[i] --;

						j -= 2;
						break;
					}
					j++;
				}

				while (j != i) {
					source[j] += 9;
					j--;
				}

				buffer[i] = 10 + source[i] - addable[i];
			}
		}
		for (int i = min_size; i < max_size; i++) {
			buffer[i] = source[i];
		}
		return new Number(buffer, ansSign);
	}

	public boolean isBigger(Number other) {
		if (longNum.length > other.getNum().length) {
			return true;
		} else if (longNum.length < other.getNum().length) {
			return false;
		} else {
			for (int i = longNum.length - 1; i >= 0; i--) {
				if (longNum[i] > other.getNum()[i]) {
					return true;
				} else if (longNum[i] < other.getNum()[i]) {
					return false;
				}
			}

			return true;
		}
	}

	public String toString() {
		String a = new String();

		for (int i = longNum.length - 1; i >= 0; i--) {
			a = a + longNum[i];
		}

		return a;
	}

	public int[] getNum() {
		return longNum;
	}

	public int getSign() {
		return sign;
	}
}