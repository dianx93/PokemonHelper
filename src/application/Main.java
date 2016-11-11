package application;
	
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private int[][] counters = new int[13][17];
	private enum Type {
		FAIRY(1), STEEL(2), NORMAL(3), DRAGON(4),
		GHOST(5), ROCK(6), BUG(7),
		PSYCHC(8), FLYING(9), GROUND(10),POISON(11),
		FIGHT(12), ICE(13), GRASS(14), ELECTR(15),
		WATER(16), FIRE(17), DARK(18);
		private int value;
		private Type(int value) { 
			this.value = value; 
		}
		public int getValue(){
			return this.value;
		}
		private static Type[] allValues = values();
	    public static Type getType(int n) {return allValues[n];}
	};
	
	private static HashMap<Type, HashSet<Type>> weakTo = new HashMap<>();
	private static HashMap<Type, HashSet<Type>> strongAgainst = new HashMap<>();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			final ObservableList<Type> types = FXCollections.observableArrayList();
			types.addAll(weakTo.keySet());
			CheckListView<Type> clview = new CheckListView<>(weakTo.keySet());
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		weakTo.put(Type.FAIRY, new HashSet<>(Arrays.asList(Type.POISON, Type.STEEL)));
		weakTo.put(Type.STEEL, new HashSet<>(Arrays.asList(Type.FIRE, Type.FIGHT, Type.GROUND)));
		weakTo.put(Type.DARK, new HashSet<>(Arrays.asList(Type.FIGHT, Type.BUG, Type.FAIRY)));
		weakTo.put(Type.DRAGON, new HashSet<>(Arrays.asList(Type.ICE, Type.DRAGON, Type.FAIRY)));
		weakTo.put(Type.GHOST, new HashSet<>(Arrays.asList(Type.GHOST, Type.DARK)));
		weakTo.put(Type.ROCK, new HashSet<>(Arrays.asList(Type.WATER, Type.GRASS, Type.FIGHT, Type.GROUND, Type.STEEL)));
		weakTo.put(Type.BUG, new HashSet<>(Arrays.asList(Type.FIRE, Type.FLYING, Type.ROCK)));
		weakTo.put(Type.PSYCHC, new HashSet<>(Arrays.asList(Type.BUG, Type.GHOST, Type.DARK)));
		weakTo.put(Type.FLYING, new HashSet<>(Arrays.asList(Type.ELECTR, Type.ICE, Type.ROCK)));
		weakTo.put(Type.GROUND, new HashSet<>(Arrays.asList(Type.WATER, Type.GRASS, Type.ICE)));
		weakTo.put(Type.POISON, new HashSet<>(Arrays.asList(Type.GROUND, Type.PSYCHC)));
		weakTo.put(Type.FIGHT, new HashSet<>(Arrays.asList(Type.FLYING, Type.PSYCHC, Type.FAIRY)));
		weakTo.put(Type.ICE, new HashSet<>(Arrays.asList(Type.FIRE, Type.FIGHT, Type.ROCK, Type.STEEL)));
		weakTo.put(Type.GRASS, new HashSet<>(Arrays.asList(Type.FIRE, Type.ICE, Type.POISON, Type.FLYING, Type.BUG)));
		weakTo.put(Type.ELECTR, new HashSet<>(Arrays.asList(Type.GROUND)));
		weakTo.put(Type.WATER, new HashSet<>(Arrays.asList(Type.ELECTR, Type.GRASS)));
		weakTo.put(Type.FIRE, new HashSet<>(Arrays.asList(Type.WATER, Type.GROUND, Type.ROCK)));
		weakTo.put(Type.NORMAL, new HashSet<>(Arrays.asList(Type.FIGHT)));
		
		for (Entry<Type, HashSet<Type>> entry : weakTo.entrySet())
		{
			HashSet<Type> values = entry.getValue();
			Type key = entry.getKey();
			for(Type value : values){
				if(strongAgainst.get(value) != null){
					strongAgainst.get(value).add(key);
				}
				else {
					strongAgainst.put(value, new HashSet<>(Arrays.asList(key)));
				}
			}
		}
		
		/*
		System.out.print("Strong:");
		System.out.print(strongAgainst.get(Type.GROUND));
		System.out.print("Weak:");
		System.out.print(weakTo.get(Type.GROUND));
		*/
		launch(args);
	}
}
