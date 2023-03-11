import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

//Bigyan Thapa

public class SortingAlgo {
	private JFrame frame;
	private JTextField inputField;
	private JTextField outputField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SortingAlgo window = new SortingAlgo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SortingAlgo() {
		initialize();
	}

	static void insertionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j > 0; j--) {
				if (arr[j] < arr[j - 1]) {
					insertionSwap(arr, j, j - 1);
				} else {
					break;
				}
			}
		}
	}

	static void insertionSwap(int[] arr, int first, int second) {
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}

	static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			// find the max item in the remaining array and swap
			// with correct index
			int last = arr.length - i - 1;
			int maxIndex = selectionGetMaxIndex(arr, 0, last);
			selectionSwap(arr, maxIndex, last);
		}
	}

	static void selectionSwap(int[] arr, int first, int second) {
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}

	static int selectionGetMaxIndex(int[] arr, int start, int end) {
		int max = start;
		for (int i = start; i <= end; i++) {
			if (arr[i] > arr[max]) {
				max = i;
			}
		}
		return max;
	}

	static void bubbleSort(int[] arr) {
		boolean swapp; // run the steps n-1 time s
		for (int i = 0; i < arr.length; i++) {
			swapp = false;
			// for each step, max item will come at the end
			for (int j = 1; j < arr.length - i; j++) {
				// swap if the item is smaller than previous item
				if (arr[j] < arr[j - 1]) {
					// swap
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
					swapp = true;
				}
			}
			// if swap do not occur than it is sorted so break
			if (!swapp) {
				break;
			}
		}
	}

	private void initialize() {
		frame = new JFrame("GUI Sorting Application Bigyan");
		frame.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 10));
		frame.setBounds(100, 100, 584, 362);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		inputField = new JTextField();
		inputField.setForeground(Color.BLACK);
		inputField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		inputField.setBounds(202, 99, 141, 27);
		frame.getContentPane().add(inputField);
		inputField.setColumns(10);
		JLabel enterNumber = new JLabel("Enter number");
		enterNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		enterNumber.setBounds(66, 102, 100, 19);
		frame.getContentPane().add(enterNumber);
		JLabel selectAlgorithm = new JLabel("Select algorithm");
		selectAlgorithm.setFont(new Font("Times New Roman", Font.BOLD, 14));
		selectAlgorithm.setBounds(66, 57, 125, 16);
		frame.getContentPane().add(selectAlgorithm);
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Selection Sort", "Insertion Sort", "Bubble Sort" }));
		comboBox.setBounds(201, 53, 142, 27);
		frame.getContentPane().add(comboBox);
		JLabel algoritmText = new JLabel("");
		algoritmText.setFont(new Font("Calibri", Font.ITALIC, 14));
		algoritmText.setBounds(227, 214, 126, 27);
		frame.getContentPane().add(algoritmText);
		JButton sortButton = new JButton("Sort");
		sortButton.setBackground(Color.BLACK);
		sortButton.setForeground(Color.WHITE);
		sortButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		sortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] input = inputField.getText().split(" ");
				String output = "";
				int[] array = new int[input.length];
				for (int i = 0; i < input.length; i++) {
					array[i] = Integer.parseInt(input[i]);
				}
				String value = comboBox.getSelectedItem().toString();
				if (value == "Insertion Sort") {
					insertionSort(array);
				} else if (value == "Selection Sort") {
					selectionSort(array);
				} else {
					bubbleSort(array);
				}
				for (int i = 0; i < array.length; i++) {
					output += array[i] + " ";
				}
				outputField.setText(output);
				algoritmText.setText(value);
			}
		});
		sortButton.setBounds(226, 136, 106, 27);
		frame.getContentPane().add(sortButton);
		JLabel sortedValue = new JLabel("Sorted value");
		sortedValue.setFont(new Font("Times New Roman", Font.BOLD, 14));
		sortedValue.setBounds(66, 178, 85, 13);
		frame.getContentPane().add(sortedValue);
		outputField = new JTextField();
		outputField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		outputField.setBounds(202, 172, 141, 27);
		frame.getContentPane().add(outputField);
		outputField.setColumns(10);
		JLabel algorithmImpl = new JLabel("Algorithm Implemented:");
		algorithmImpl.setFont(new Font("Times New Roman", Font.BOLD, 14));
		algorithmImpl.setBounds(67, 213, 156, 29);
		frame.getContentPane().add(algorithmImpl);

		JLabel lblNewLabel = new JLabel("GUI Application for Sorting the Numbers");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(68, 10, 264, 33);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblCreatedBy = new JLabel("Created By:  Bigyan Thapa");
		lblCreatedBy.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblCreatedBy.setBounds(319, 261, 173, 33);
		frame.getContentPane().add(lblCreatedBy);
	}
}