package Vue;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel
{
	private static final long serialVersionUID = 1L;
	protected JLabel titre = new JLabel(""); 
	public PanelPrincipal()
	{
		//les caractéristiques communes aux différents Panels 
		this.setBounds(50, 80, 850, 330);
		this.setBackground(new Color (234, 176, 69));
		this.setLayout(null);
		
		this.titre.setBounds(300, 10, 300, 20);
		this.add(this.titre);
		
		this.setVisible(false);
	}
}
