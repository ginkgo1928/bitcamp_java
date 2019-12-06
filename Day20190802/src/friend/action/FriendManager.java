package friend.action;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import friend.bean.FriendDTO;
import friend.dao.FriendDAO;

public class FriendManager extends JFrame implements ActionListener{
	private JLabel infoinputL, nameL, telL, sexL, hobbyL, tot_listL, infoL, dashL1, dashL2;
	private JTextField nameT, tel2T, tel3T;
	private JComboBox<String> tel1C;
	private JRadioButton manR, womanR;
	private JCheckBox readCB, movieCB, musicCB, gameCB, shoppingCB;
	private JList<FriendDTO> list;
	private DefaultListModel<FriendDTO> model;
	private JTextArea area;
	private JButton addB, updateB, deleteB, clearB;

	public FriendManager() {
		setTitle("Friend Manager");
		JPanel pW1 = new JPanel();
		infoinputL = new JLabel("개인정보입력");
		pW1.add(infoinputL);

		JPanel pW2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		nameL = new JLabel("이     름 : ");
		nameT = new JTextField(15);
		pW2.add(nameL);
		pW2.add(nameT);

		JPanel pW3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		telL = new JLabel("전화번호 : ");
		String[] cItems = { "010", "011"};
		tel1C = new JComboBox<String>(cItems);
		dashL1 = new JLabel("-");
		tel2T = new JTextField(5);
		dashL2 = new JLabel("-");
		tel3T = new JTextField(5);
		pW3.add(telL);
		pW3.add(tel1C);
		pW3.add(dashL1);
		pW3.add(tel2T);
		pW3.add(dashL2);
		pW3.add(tel3T);

		JPanel pW4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		sexL = new JLabel("성     별 : ");
		manR = new JRadioButton("남성", true);
		womanR = new JRadioButton("여성");
		
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(manR);
		btnGroup.add(womanR);
		
		pW4.add(sexL);
		pW4.add(manR);
		pW4.add(womanR);

		JPanel pW5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		hobbyL = new JLabel("취미");
		readCB = new JCheckBox("독서");
		movieCB = new JCheckBox("영화");
		musicCB = new JCheckBox("음악");
		gameCB = new JCheckBox("게임");
		shoppingCB = new JCheckBox("쇼핑");
	
		pW5.add(hobbyL);
		pW5.add(readCB);
		pW5.add(movieCB);
		pW5.add(musicCB);
		pW5.add(gameCB);
		pW5.add(shoppingCB);

		JPanel pW6 = new JPanel();
		addB = new JButton("등록");
		updateB = new JButton("수정");
		deleteB = new JButton("삭제");
		clearB = new JButton("지우기");
		
		addB.setEnabled(true);
		updateB.setEnabled(false);
		deleteB.setEnabled(false);
		clearB.setEnabled(false);

		pW6.add(addB);
		pW6.add(updateB);
		pW6.add(deleteB);
		pW6.add(clearB);

		JPanel pWest = new JPanel(new GridLayout(6, 1));

		pWest.add(pW1);
		pWest.add(pW2);
		pWest.add(pW3);
		pWest.add(pW4);
		pWest.add(pW5);
		pWest.add(pW6);
		JPanel pEast = new JPanel(new BorderLayout());
		JPanel pE1 = new JPanel();
		tot_listL = new JLabel("전체목록            ");
		pE1.add(tot_listL);

		JPanel pE2 = new JPanel();	
		list = new JList<FriendDTO>(new DefaultListModel<FriendDTO>());
		model = (DefaultListModel<FriendDTO>)list.getModel();
		
		JScrollPane scroll = new JScrollPane(list);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(300, 250));
		pE2.add(scroll);
		pEast.add("North", pE1);
		pEast.add("Center", pE2);

		JPanel pSouth = new JPanel(new BorderLayout());

		JPanel pS1 = new JPanel();
		infoL = new JLabel("개인정보분석");
		pS1.add(infoL);

		JPanel pS2 = new JPanel();
		area = new JTextArea(5, 50);
		JScrollPane scroll2 = new JScrollPane(area);
		scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pS2.add(scroll2);

		pSouth.add("North", pS1);
		pSouth.add("Center", pS2);

		Container contentPane = this.getContentPane();
		contentPane.add("West", pWest);
		contentPane.add("East", pEast);
		contentPane.add("South", pSouth);

		setBounds(50, 50, 630, 520);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//DB에서 모든 레코드들을 꺼내서 JList 뿌리기

	}

	private void event() {
		addB.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==addB) {
			//데이터
			String name = nameT.getText();
			String tel1 = (String)tel1C.getSelectedItem();
			String tel2 = tel2T.getText();
			String tel3 = tel3T.getText();
			int gender=0;
			if(manR.isSelected())
				gender = 0;
			else if(womanR.isSelected())
				gender = 1;
			int read = readCB.isSelected() ? 1 : 0;
			int movie = movieCB.isSelected() ? 1 : 0;
			int music = musicCB.isSelected() ? 1 : 0;
			int game = gameCB.isSelected() ? 1 : 0;
			int shopping = shoppingCB.isSelected() ? 1 : 0;
			
			FriendDTO dto = new FriendDTO();
			dto.setName(name);
			dto.setTel1(tel1);
			dto.setTel2(tel2);
			dto.setTel3(tel3);
			dto.setGender(gender);
			dto.setRead(read);
			dto.setMovie(movie);
			dto.setMusic(music);
			dto.setGame(game);
			dto.setShopping(shopping);		
			
			//DB
			FriendDAO dao = FriendDAO.getInstance();
			
			int seq = dao.getSeq();
			
			dto.setSeq(seq);
			int su = dao.insertFriend(dto);
			
			//응답
			clear();
			
			if(su==1)
				area.setText("\n\t\t 데이터 등록 완료");
			else 
				area.setText("\n\t\t 데이터 등록 실패");
			
			model.addElement(dto);
			
		}
		
	}
	
	public void clear() {
		nameT.setText("");
		tel1C.setSelectedItem("010");
		tel2T.setText("");
		tel3T.setText("");
		manR.setSelected(true);
		readCB.setSelected(false);
		movieCB.setSelected(false);
		musicCB.setSelected(false);
		gameCB.setSelected(false);
		shoppingCB.setSelected(false);
		
		area.setText("");
	}

	
	public static void main(String[] args) {
		new FriendManager().event();
	}
}// class
