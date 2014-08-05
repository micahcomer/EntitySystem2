package com.mjc.systems;

import java.util.ArrayList;
import java.util.LinkedList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;

import com.example.entitysystem.R;
import com.mjc.components.Animation;
import com.mjc.components.Position;
import com.mjc.entitysystem.Component;
import com.mjc.entitysystem.EntityManager;
import com.mjc.entitysystem.SubSystem;
import com.mjc.tools.DrawTools;
import com.mjc.tools.GameLoader;

public class AnimationSystem extends SubSystem {

	public AnimationSystem() {
		super();
	}

	public static int createNewEntityForAnimation(Context c, String path, Point totalCells) {

		ArrayList<Class<? extends Component>> classes = new ArrayList<Class<? extends Component>>();
		classes.add(Animation.class);
		classes.add(Position.class);

		int animationID = EntityManager.createEntity(classes);
		Animation a = (Animation) EntityManager.getComponent(Animation.class, animationID);

		a.spriteStrip = GameLoader.loadBitmap(c, path);
		a.totalCells = totalCells;
		a.cellSize.x = (a.spriteStrip.getWidth() / totalCells.x);
		a.cellSize.y = (a.spriteStrip.getWidth() / totalCells.y);
		a.currentCell.x = 0;
		a.currentCell.y = 0;
		a.sourceRect.set(0, 0, a.cellSize.x, a.cellSize.y);
		a.onScreenSize.set(0, 0, a.cellSize.x, a.cellSize.y);

		return animationID;
	}

	public static int createNewEntityForAnimation(Context c, String path,
			Point totalCells, int frameRate) {

		int animationID = createNewEntityForAnimation(c, path, totalCells);
		Animation a = (Animation) EntityManager.getComponent(Animation.class,
				animationID);
		a.frameRate = frameRate;
		return animationID;
	}

	public static void updateAnimations(long beforeTime) {
		try {
			@SuppressWarnings("unchecked")
			LinkedList<Animation> anims = (LinkedList<Animation>) EntityManager
					.getAllComponentsOfType(Animation.class);
			for (Animation a : anims) {
				if (a.running) {
					long elapsedTime = beforeTime - a.lastFrameTime;

					if (elapsedTime >= ((1.0f / (float) (a.frameRate)) * 1000000000f)) {
						updateAnimation(a);
						if (!a.running) {
							anims.remove(a);
						} else {
							a.lastFrameTime = beforeTime;
						}
					}
				}

			}
		} catch (ClassCastException e) {
			Log.e("AnimationSystem",
					"List of entities from Entity Manager was not a Linked List of Animations");
		}
	}

	public static void rescaleAnimation(float scaleFactor, int animationID) {
		Animation a = (Animation) EntityManager.getComponent(Animation.class,
				animationID);
		a.onScreenSize.set(new Rect(0, 0,
				(int) (a.onScreenSize.left * scaleFactor),
				(int) (a.onScreenSize.bottom * scaleFactor)));
	}

	private static void updateAnimation(Animation a) {
		a.currentCell.x++;
		if (a.currentCell.x == a.totalCells.x) {
			a.currentCell.x = 0;
			a.currentCell.y++;
			if (a.currentCell.y == a.totalCells.y) {
				if (a.repeats) {
					a.currentCell.y = 0;
				} else {
					a.running = false;
				}
			}
		}
		a.sourceRect.set(a.currentCell.x*a.cellSize.x, a.currentCell.y*a.cellSize.y, a.currentCell.x
				* a.cellSize.x + a.cellSize.x, a.currentCell.y * a.cellSize.y+a.cellSize.y);
	}

}
