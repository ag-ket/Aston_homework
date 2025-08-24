package pattern;

import java.util.HashMap;

public class Proxy {
	
	private static HashMap <String, String> authMap = new HashMap<>() {{
		put("boss", "12345");
		put("non-boss", "54321");
		put("reallyDifficultPassword", "07Kia-!uT");
	}};

	public static void main(String[] args) {
		FakeBoringLab fakeLab1 = new FakeBoringLab("", "");
		FakeBoringLab fakeLab2 = new FakeBoringLab("boss", "12345");
		
		System.out.println(fakeLab1.findPotion("purple"));
		System.out.println(fakeLab1.findSecretDocuments());
		System.out.println(fakeLab1.findRandomZombieFiles());
		
		System.out.println(fakeLab2.findPotion("purple"));
		System.out.println(fakeLab2.findSecretDocuments());
		System.out.println(fakeLab2.findRandomZombieFiles());

	}
	
	static class curePotion
	{
		String color;
		
		curePotion(String color)
		{
			this.color = color;
		}
		
		String potion ()
		{
			switch (color)
			{
			case "white":
				return "Найдено белое зелье. Оно безусловно лечебное, но не помогает от зомбификации";
			case "red":
				return "Найдено красное зелье. Хоть и подозрителен  его цвет, но зомби после него нет";
			case "black":
				return "Найдено чёрное зелье. ЛОЖИИИИИИСЬ";
			case "purple":
				return "Найдено фиолетовое зелье. Это отличное средство, чтобы уснуть вечным сном";
			default:
				return "Этого зелья нет в зельеэнциклопедии, употребление не рекомендуется";
			}
		}
		
		
	}
	
	static class SecretZombieLab implements LabStaff{

		@Override
		public String findPotion(String s) {
			curePotion potion = new curePotion(s);
			return potion.potion();
		}

		@Override
		public String findSecretDocuments() {

			return "Найдена куча секретных документов, подтверждающих, что лаборатория ответственна за появление зомби";
		}

		@Override
		public String findRandomZombieFiles() {

			return "Найдена тонна документов, описывающих зомби";
		}
		
	}
	static class FakeBoringLab implements LabStaff{
		
		boolean authority;
		String login;
		String password;
		
		
		SecretZombieLab secretLab = new SecretZombieLab();
		
		FakeBoringLab(String login, String password)
		{
			this.login = login;
			this.password = password;
			authority = authMap.containsKey(login) && password.equals(authMap.get(login));
		}

		boolean isAuth()
		{
			return authority;
		}

		@Override
		public String findPotion(String s) {
			if (isAuth())
				return secretLab.findPotion(s);
			else
				return "В этой лаборатории нет никаких зелий";
		}

		@Override
		public String findSecretDocuments() {
			if (isAuth())
				return secretLab.findSecretDocuments();
			else
				return "В этой лаборатории нет никаких документов";
		}

		@Override
		public String findRandomZombieFiles() {
			if (isAuth())
				return secretLab.findRandomZombieFiles();
			else
				return "В этой лаборатории нет никакой информации о зомби";
		}

		
		
	}
	
	
	interface LabStaff{
		
		String findPotion(String s);
		String findSecretDocuments();
		String findRandomZombieFiles();
		
	}

}
