interface Entity {
	public int GetHP();
	public void TurnOfEntity(Entity[] warriors);
	public void Damage(int damage);
	public boolean IsKilled();
}