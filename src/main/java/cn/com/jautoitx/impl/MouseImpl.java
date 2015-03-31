package cn.com.jautoitx.impl;

import cn.com.jautoitx.Mouse;
import cn.com.jautoitx.util.AutoItUtils;
import org.apache.commons.lang3.StringUtils;

import com.sun.jna.platform.win32.WinDef.POINT;

public final class MouseImpl implements Mouse {


	/**
	 * Perform a mouse click operation.
	 * 
	 * If the button is an empty string, the left button will be clicked.
	 * 
	 * If the button is not in the list, then false will be returned.
	 * 
	 * If the user has swapped the left and right mouse buttons in the control
	 * panel, then the behaviour of the buttons is different. "Left" and "right"
	 * always click those buttons, whether the buttons are swapped or not. The
	 * "primary" or "main" button will be the main click, whether or not the
	 * buttons are swapped. The "secondary" or "menu" buttons will usually bring
	 * up the context menu, whether the buttons are swapped or not.
	 * 
	 * <table width="100%" border="1">
	 * <tr>
	 * <td><b>Button</b></td>
	 * <td><b>Normal</b></td>
	 * <td><b>Swapped</b></td>
	 * </tr>
	 * <tr>
	 * <td>""</td>
	 * <td>Left</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"left"</td>
	 * <td>Left</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"middle"</td>
	 * <td>Middle</td>
	 * <td>Middle</td>
	 * </tr>
	 * <tr>
	 * <td>"right"</td>
	 * <td>Right</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"primary"</td>
	 * <td>Left</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"main"</td>
	 * <td>Left</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"secondary"</td>
	 * <td>Right</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"menu"</td>
	 * <td>Right</td>
	 * <td>Left</td>
	 * </tr>
	 * </table>
	 * 
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean click() {
		return click((String) null);
	}

	/**
	 * Perform a mouse click operation.
	 * 
	 * If the button is an empty string, the left button will be clicked.
	 * 
	 * If the button is not in the list, then false will be returned.
	 * 
	 * If the user has swapped the left and right mouse buttons in the control
	 * panel, then the behaviour of the buttons is different. "Left" and "right"
	 * always click those buttons, whether the buttons are swapped or not. The
	 * "primary" or "main" button will be the main click, whether or not the
	 * buttons are swapped. The "secondary" or "menu" buttons will usually bring
	 * up the context menu, whether the buttons are swapped or not.
	 * 
	 * <table width="100%" border="1">
	 * <tr>
	 * <td><b>Button</b></td>
	 * <td><b>Normal</b></td>
	 * <td><b>Swapped</b></td>
	 * </tr>
	 * <tr>
	 * <td>""</td>
	 * <td>Left</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"left"</td>
	 * <td>Left</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"middle"</td>
	 * <td>Middle</td>
	 * <td>Middle</td>
	 * </tr>
	 * <tr>
	 * <td>"right"</td>
	 * <td>Right</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"primary"</td>
	 * <td>Left</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"main"</td>
	 * <td>Left</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"secondary"</td>
	 * <td>Right</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"menu"</td>
	 * <td>Right</td>
	 * <td>Left</td>
	 * </tr>
	 * </table>
	 * 
	 * @param button
	 *            see {@link #click(String)}
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean click(final MouseButton button) {
		return click(button.getButton());
	}

	/**
	 * Perform a mouse click operation.
	 * 
	 * If the button is an empty string, the left button will be clicked.
	 * 
	 * If the button is not in the list, then false will be returned.
	 * 
	 * If the user has swapped the left and right mouse buttons in the control
	 * panel, then the behaviour of the buttons is different. "Left" and "right"
	 * always click those buttons, whether the buttons are swapped or not. The
	 * "primary" or "main" button will be the main click, whether or not the
	 * buttons are swapped. The "secondary" or "menu" buttons will usually bring
	 * up the context menu, whether the buttons are swapped or not.
	 * 
	 * <table width="100%" border="1">
	 * <tr>
	 * <td><b>Button</b></td>
	 * <td><b>Normal</b></td>
	 * <td><b>Swapped</b></td>
	 * </tr>
	 * <tr>
	 * <td>""</td>
	 * <td>Left</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"left"</td>
	 * <td>Left</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"middle"</td>
	 * <td>Middle</td>
	 * <td>Middle</td>
	 * </tr>
	 * <tr>
	 * <td>"right"</td>
	 * <td>Right</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"primary"</td>
	 * <td>Left</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"main"</td>
	 * <td>Left</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"secondary"</td>
	 * <td>Right</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"menu"</td>
	 * <td>Right</td>
	 * <td>Left</td>
	 * </tr>
	 * </table>
	 * 
	 * @param button
	 *            The button to click: "left", "right", "middle", "main",
	 *            "menu", "primary", "secondary".
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean click(final String button) {
		return click(button, null, null);
	}

	/**
	 * Perform a mouse click operation.
	 * 
	 * If the button is an empty string, the left button will be clicked.
	 * 
	 * If the button is not in the list, then false will be returned.
	 * 
	 * If the user has swapped the left and right mouse buttons in the control
	 * panel, then the behaviour of the buttons is different. "Left" and "right"
	 * always click those buttons, whether the buttons are swapped or not. The
	 * "primary" or "main" button will be the main click, whether or not the
	 * buttons are swapped. The "secondary" or "menu" buttons will usually bring
	 * up the context menu, whether the buttons are swapped or not.
	 * 
	 * <table width="100%" border="1">
	 * <tr>
	 * <td><b>Button</b></td>
	 * <td><b>Normal</b></td>
	 * <td><b>Swapped</b></td>
	 * </tr>
	 * <tr>
	 * <td>""</td>
	 * <td>Left</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"left"</td>
	 * <td>Left</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"middle"</td>
	 * <td>Middle</td>
	 * <td>Middle</td>
	 * </tr>
	 * <tr>
	 * <td>"right"</td>
	 * <td>Right</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"primary"</td>
	 * <td>Left</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"main"</td>
	 * <td>Left</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"secondary"</td>
	 * <td>Right</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"menu"</td>
	 * <td>Right</td>
	 * <td>Left</td>
	 * </tr>
	 * </table>
	 * 
	 * @param button
	 *            see {@link #click(String, Integer, Integer, Integer, Integer)}
	 * @param x
	 *            The x coordinate to move the mouse to. If no x and y coords
	 *            are given, the current position is used.
	 * @param y
	 *            The y coordinate to move the mouse to. If no x and y coords
	 *            are given, the current position is used.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean click(final MouseButton button, final Integer x,
			final Integer y) {
		return click(button.getButton(), x, y);
	}

	/**
	 * Perform a mouse click operation.
	 * 
	 * If the button is an empty string, the left button will be clicked.
	 * 
	 * If the button is not in the list, then false will be returned.
	 * 
	 * If the user has swapped the left and right mouse buttons in the control
	 * panel, then the behaviour of the buttons is different. "Left" and "right"
	 * always click those buttons, whether the buttons are swapped or not. The
	 * "primary" or "main" button will be the main click, whether or not the
	 * buttons are swapped. The "secondary" or "menu" buttons will usually bring
	 * up the context menu, whether the buttons are swapped or not.
	 * 
	 * <table width="100%" border="1">
	 * <tr>
	 * <td><b>Button</b></td>
	 * <td><b>Normal</b></td>
	 * <td><b>Swapped</b></td>
	 * </tr>
	 * <tr>
	 * <td>""</td>
	 * <td>Left</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"left"</td>
	 * <td>Left</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"middle"</td>
	 * <td>Middle</td>
	 * <td>Middle</td>
	 * </tr>
	 * <tr>
	 * <td>"right"</td>
	 * <td>Right</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"primary"</td>
	 * <td>Left</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"main"</td>
	 * <td>Left</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"secondary"</td>
	 * <td>Right</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"menu"</td>
	 * <td>Right</td>
	 * <td>Left</td>
	 * </tr>
	 * </table>
	 * 
	 * @param button
	 *            The button to click: "left", "right", "middle", "main",
	 *            "menu", "primary", "secondary".
	 * @param x
	 *            The x coordinate to move the mouse to. If no x and y coords
	 *            are given, the current position is used.
	 * @param y
	 *            The y coordinate to move the mouse to. If no x and y coords
	 *            are given, the current position is used.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean click(final String button, final Integer x,
			final Integer y) {
		return click(button, x, y, null);
	}

	/**
	 * Perform a mouse click operation.
	 * 
	 * If the button is an empty string, the left button will be clicked.
	 * 
	 * If the button is not in the list, then false will be returned.
	 * 
	 * If the user has swapped the left and right mouse buttons in the control
	 * panel, then the behaviour of the buttons is different. "Left" and "right"
	 * always click those buttons, whether the buttons are swapped or not. The
	 * "primary" or "main" button will be the main click, whether or not the
	 * buttons are swapped. The "secondary" or "menu" buttons will usually bring
	 * up the context menu, whether the buttons are swapped or not.
	 * 
	 * <table width="100%" border="1">
	 * <tr>
	 * <td><b>Button</b></td>
	 * <td><b>Normal</b></td>
	 * <td><b>Swapped</b></td>
	 * </tr>
	 * <tr>
	 * <td>""</td>
	 * <td>Left</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"left"</td>
	 * <td>Left</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"middle"</td>
	 * <td>Middle</td>
	 * <td>Middle</td>
	 * </tr>
	 * <tr>
	 * <td>"right"</td>
	 * <td>Right</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"primary"</td>
	 * <td>Left</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"main"</td>
	 * <td>Left</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"secondary"</td>
	 * <td>Right</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"menu"</td>
	 * <td>Right</td>
	 * <td>Left</td>
	 * </tr>
	 * </table>
	 * 
	 * @param button
	 *            see {@link #click(String, Integer, Integer, Integer, Integer)}
	 * @param x
	 *            The x coordinate to move the mouse to. If no x and y coords
	 *            are given, the current position is used.
	 * @param y
	 *            The y coordinate to move the mouse to. If no x and y coords
	 *            are given, the current position is used.
	 * @param clicks
	 *            The number of times to click the mouse. Default is 1.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean click(final MouseButton button, final Integer x,
			final Integer y, final Integer clicks) {
		return click(button.getButton(), x, y, clicks);
	}

	/**
	 * Perform a mouse click operation.
	 * 
	 * If the button is an empty string, the left button will be clicked.
	 * 
	 * If the button is not in the list, then false will be returned.
	 * 
	 * If the user has swapped the left and right mouse buttons in the control
	 * panel, then the behaviour of the buttons is different. "Left" and "right"
	 * always click those buttons, whether the buttons are swapped or not. The
	 * "primary" or "main" button will be the main click, whether or not the
	 * buttons are swapped. The "secondary" or "menu" buttons will usually bring
	 * up the context menu, whether the buttons are swapped or not.
	 * 
	 * <table width="100%" border="1">
	 * <tr>
	 * <td><b>Button</b></td>
	 * <td><b>Normal</b></td>
	 * <td><b>Swapped</b></td>
	 * </tr>
	 * <tr>
	 * <td>""</td>
	 * <td>Left</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"left"</td>
	 * <td>Left</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"middle"</td>
	 * <td>Middle</td>
	 * <td>Middle</td>
	 * </tr>
	 * <tr>
	 * <td>"right"</td>
	 * <td>Right</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"primary"</td>
	 * <td>Left</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"main"</td>
	 * <td>Left</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"secondary"</td>
	 * <td>Right</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"menu"</td>
	 * <td>Right</td>
	 * <td>Left</td>
	 * </tr>
	 * </table>
	 * 
	 * @param button
	 *            The button to click: "left", "right", "middle", "main",
	 *            "menu", "primary", "secondary".
	 * @param x
	 *            The x coordinate to move the mouse to. If no x and y coords
	 *            are given, the current position is used.
	 * @param y
	 *            The y coordinate to move the mouse to. If no x and y coords
	 *            are given, the current position is used.
	 * @param clicks
	 *            The number of times to click the mouse. Default is 1.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean click(final String button, final Integer x,
			final Integer y, final Integer clicks) {
		return click(button, x, y, clicks, null);
	}

	/**
	 * Perform a mouse click operation.
	 * 
	 * If the button is an empty string, the left button will be clicked.
	 * 
	 * If the button is not in the list, then false will be returned.
	 * 
	 * If the user has swapped the left and right mouse buttons in the control
	 * panel, then the behaviour of the buttons is different. "Left" and "right"
	 * always click those buttons, whether the buttons are swapped or not. The
	 * "primary" or "main" button will be the main click, whether or not the
	 * buttons are swapped. The "secondary" or "menu" buttons will usually bring
	 * up the context menu, whether the buttons are swapped or not.
	 * 
	 * <table width="100%" border="1">
	 * <tr>
	 * <td><b>Button</b></td>
	 * <td><b>Normal</b></td>
	 * <td><b>Swapped</b></td>
	 * </tr>
	 * <tr>
	 * <td>""</td>
	 * <td>Left</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"left"</td>
	 * <td>Left</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"middle"</td>
	 * <td>Middle</td>
	 * <td>Middle</td>
	 * </tr>
	 * <tr>
	 * <td>"right"</td>
	 * <td>Right</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"primary"</td>
	 * <td>Left</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"main"</td>
	 * <td>Left</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"secondary"</td>
	 * <td>Right</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"menu"</td>
	 * <td>Right</td>
	 * <td>Left</td>
	 * </tr>
	 * </table>
	 * 
	 * @param button
	 *            see {@link #click(String, Integer, Integer, Integer, Integer)}
	 * @param x
	 *            The x coordinate to move the mouse to. If no x and y coords
	 *            are given, the current position is used.
	 * @param y
	 *            The y coordinate to move the mouse to. If no x and y coords
	 *            are given, the current position is used.
	 * @param clicks
	 *            The number of times to click the mouse. Default is 1.
	 * @param speed
	 *            the speed to move the mouse in the range 1 (fastest) to 100
	 *            (slowest). A speed of 0 will move the mouse instantly. Default
	 *            speed is 10.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean click(final MouseButton button, final Integer x,
			final Integer y, final Integer clicks, final Integer speed) {
		return click(button.getButton(), x, y, clicks, speed);
	}

	/**
	 * Perform a mouse click operation.
	 * 
	 * If the button is an empty string, the left button will be clicked.
	 * 
	 * If the button is not in the list, then false will be returned.
	 * 
	 * If the user has swapped the left and right mouse buttons in the control
	 * panel, then the behaviour of the buttons is different. "Left" and "right"
	 * always click those buttons, whether the buttons are swapped or not. The
	 * "primary" or "main" button will be the main click, whether or not the
	 * buttons are swapped. The "secondary" or "menu" buttons will usually bring
	 * up the context menu, whether the buttons are swapped or not.
	 * 
	 * <table width="100%" border="1">
	 * <tr>
	 * <td><b>Button</b></td>
	 * <td><b>Normal</b></td>
	 * <td><b>Swapped</b></td>
	 * </tr>
	 * <tr>
	 * <td>""</td>
	 * <td>Left</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"left"</td>
	 * <td>Left</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"middle"</td>
	 * <td>Middle</td>
	 * <td>Middle</td>
	 * </tr>
	 * <tr>
	 * <td>"right"</td>
	 * <td>Right</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"primary"</td>
	 * <td>Left</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"main"</td>
	 * <td>Left</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"secondary"</td>
	 * <td>Right</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"menu"</td>
	 * <td>Right</td>
	 * <td>Left</td>
	 * </tr>
	 * </table>
	 * 
	 * @param button
	 *            The button to click: "left", "right", "middle", "main",
	 *            "menu", "primary", "secondary".
	 * @param x
	 *            The x coordinate to move the mouse to. If no x and y coords
	 *            are given, the current position is used.
	 * @param y
	 *            The y coordinate to move the mouse to. If no x and y coords
	 *            are given, the current position is used.
	 * @param clicks
	 *            The number of times to click the mouse. Default is 1.
	 * @param speed
	 *            the speed to move the mouse in the range 1 (fastest) to 100
	 *            (slowest). A speed of 0 will move the mouse instantly. Default
	 *            speed is 10.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean click(final String button, Integer x, Integer y,
			final Integer clicks, final Integer speed) {
		// button is not in the list
		if (!checkMouseButton(button)) {
			return false;
		}

		if (x == null || y == null) {
			x = getPosX();
			y = getPosY();
		}
		AutoItXImpl.autoItX.AU3_MouseClick(AutoItUtils.stringToWString(AutoItUtils.defaultString(button)
						.toLowerCase()), x, y,
				(clicks == null) ? DEFAULT_MOUSE_CLICK_TIMES : clicks,
				(speed == null) ? DEFAULT_MOUSE_MOVE_SPEED : speed);
		return !LocalInstances.autoItX.hasError();
	}

	/**
	 * Perform a mouse click and drag operation.
	 * 
	 * If the button is an empty string, the left button will be clicked.
	 * 
	 * If the button is not in the list, then false will be returned.
	 * 
	 * If the user has swapped the left and right mouse buttons in the control
	 * panel, then the behaviour of the buttons is different. "Left" and "right"
	 * always click those buttons, whether the buttons are swapped or not. The
	 * "primary" or "main" button will be the main click, whether or not the
	 * buttons are swapped. The "secondary" or "menu" buttons will usually bring
	 * up the context menu, whether the buttons are swapped or not. See the
	 * table in MouseClick for more explaination
	 * 
	 * @param x1
	 *            The x coord to start the drag operation from.
	 * @param y1
	 *            The y coord to start the drag operation from.
	 * @param x2
	 *            The x coord to start the drag operation to.
	 * @param y2
	 *            The y coord to start the drag operation to.
	 * @return Returns true if success, return false if failed.
	 */
	public boolean clickDrag(final int x1, final int y1, final int x2,
			final int y2) {
		return clickDrag((String) null, x1, y1, x2, y2);
	}

	/**
	 * Perform a mouse click and drag operation.
	 * 
	 * If the button is an empty string, the left button will be clicked.
	 * 
	 * If the button is not in the list, then false will be returned.
	 * 
	 * If the user has swapped the left and right mouse buttons in the control
	 * panel, then the behaviour of the buttons is different. "Left" and "right"
	 * always click those buttons, whether the buttons are swapped or not. The
	 * "primary" or "main" button will be the main click, whether or not the
	 * buttons are swapped. The "secondary" or "menu" buttons will usually bring
	 * up the context menu, whether the buttons are swapped or not. See the
	 * table in MouseClick for more explaination
	 * 
	 * @param button
	 *            The button to click: "left", "right", "middle", "main",
	 *            "menu", "primary", "secondary".
	 * @param x1
	 *            The x coord to start the drag operation from.
	 * @param y1
	 *            The y coord to start the drag operation from.
	 * @param x2
	 *            The x coord to start the drag operation to.
	 * @param y2
	 *            The y coord to start the drag operation to.
	 * @return Returns true if success, return false if failed.
	 */
	public boolean clickDrag(final MouseButton button, final int x1,
			final int y1, final int x2, final int y2) {
		return clickDrag(button.getButton(), x1, y1, x2, y2);
	}

	/**
	 * Perform a mouse click and drag operation.
	 * 
	 * If the button is an empty string, the left button will be clicked.
	 * 
	 * If the button is not in the list, then false will be returned.
	 * 
	 * If the user has swapped the left and right mouse buttons in the control
	 * panel, then the behaviour of the buttons is different. "Left" and "right"
	 * always click those buttons, whether the buttons are swapped or not. The
	 * "primary" or "main" button will be the main click, whether or not the
	 * buttons are swapped. The "secondary" or "menu" buttons will usually bring
	 * up the context menu, whether the buttons are swapped or not. See the
	 * table in MouseClick for more explaination
	 * 
	 * @param button
	 *            The button to click: "left", "right", "middle", "main",
	 *            "menu", "primary", "secondary".
	 * @param x1
	 *            The x coord to start the drag operation from.
	 * @param y1
	 *            The y coord to start the drag operation from.
	 * @param x2
	 *            The x coord to start the drag operation to.
	 * @param y2
	 *            The y coord to start the drag operation to.
	 * @return Returns true if success, return false if failed.
	 */
	public boolean clickDrag(final String button, final int x1,
			final int y1, final int x2, final int y2) {
		return clickDrag(button, x1, y1, x2, y2, null);
	}

	/**
	 * Perform a mouse click and drag operation.
	 * 
	 * If the button is an empty string, the left button will be clicked.
	 * 
	 * If the button is not in the list, then false will be returned.
	 * 
	 * If the user has swapped the left and right mouse buttons in the control
	 * panel, then the behaviour of the buttons is different. "Left" and "right"
	 * always click those buttons, whether the buttons are swapped or not. The
	 * "primary" or "main" button will be the main click, whether or not the
	 * buttons are swapped. The "secondary" or "menu" buttons will usually bring
	 * up the context menu, whether the buttons are swapped or not. See the
	 * table in MouseClick for more explaination
	 * 
	 * @param button
	 *            The button to click: "left", "right", "middle", "main",
	 *            "menu", "primary", "secondary".
	 * @param x1
	 *            The x coord to start the drag operation from.
	 * @param y1
	 *            The y coord to start the drag operation from.
	 * @param x2
	 *            The x coord to start the drag operation to.
	 * @param y2
	 *            The y coord to start the drag operation to.
	 * @param speed
	 *            the speed to move the mouse in the range 1 (fastest) to 100
	 *            (slowest). A speed of 0 will move the mouse instantly. Default
	 *            speed is 10.
	 * @return Returns true if success, return false if failed.
	 */
	public boolean clickDrag(final MouseButton button, final int x1,
			final int y1, final int x2, final int y2, final Integer speed) {
		return clickDrag(button.getButton(), x1, y1, x2, y2, speed);
	}

	/**
	 * Perform a mouse click and drag operation.
	 * 
	 * If the button is an empty string, the left button will be clicked.
	 * 
	 * If the button is not in the list, then false will be returned.
	 * 
	 * If the user has swapped the left and right mouse buttons in the control
	 * panel, then the behaviour of the buttons is different. "Left" and "right"
	 * always click those buttons, whether the buttons are swapped or not. The
	 * "primary" or "main" button will be the main click, whether or not the
	 * buttons are swapped. The "secondary" or "menu" buttons will usually bring
	 * up the context menu, whether the buttons are swapped or not. See the
	 * table in MouseClick for more explaination
	 * 
	 * @param button
	 *            The button to click: "left", "right", "middle", "main",
	 *            "menu", "primary", "secondary".
	 * @param x1
	 *            The x coord to start the drag operation from.
	 * @param y1
	 *            The y coord to start the drag operation from.
	 * @param x2
	 *            The x coord to start the drag operation to.
	 * @param y2
	 *            The y coord to start the drag operation to.
	 * @param speed
	 *            the speed to move the mouse in the range 1 (fastest) to 100
	 *            (slowest). A speed of 0 will move the mouse instantly. Default
	 *            speed is 10.
	 * @return Returns true if success, return false if failed.
	 */
	public boolean clickDrag(final String button, final int x1,
			final int y1, final int x2, final int y2, final Integer speed) {
		// button is not in the list
		if (!checkMouseButton(button)) {
			return false;
		}

		AutoItXImpl.autoItX.AU3_MouseClickDrag(AutoItUtils.stringToWString(AutoItUtils.defaultString(button)), x1,
				y1, x2, y2, speed);
		return !LocalInstances.autoItX.hasError();
	}

	/**
	 * Perform a mouse down event at the current mouse position.
	 * 
	 * Use responsibly: For every MouseDown there should eventually be a
	 * corresponding MouseUp event.
	 * 
	 * @param button
	 *            see {@link #down(String)}
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean down(final MouseButton button) {
		return down(button.getButton());
	}

	/**
	 * Perform a mouse down event at the current mouse position.
	 * 
	 * Use responsibly: For every MouseDown there should eventually be a
	 * corresponding MouseUp event.
	 * 
	 * @param button
	 *            The button to click: "left", "right", "middle", "main",
	 *            "menu", "primary", "secondary".
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean down(final String button) {
		if (!checkMouseButton(button)) {
			return false;
		}
		int currentMouseClickDownDelay = LocalInstances.opt.currentMouseClickDownDelay;

		long start = System.currentTimeMillis();
		AutoItXImpl.autoItX.AU3_MouseDown(AutoItUtils.stringToWString(button));
		boolean status = !LocalInstances.autoItX.hasError();
		long delay = System.currentTimeMillis() - start;

		// Note: fix AutoItX 3.3.10.2's bug
		while (currentMouseClickDownDelay > delay) {
			try {
				Thread.sleep((int) (currentMouseClickDownDelay - delay));
			} catch (InterruptedException e) {
				// Ignore exception
			}
			delay = System.currentTimeMillis() - start;
		}

		return status;
	}

	/**
	 * Moves the mouse pointer and perform a mouse down event at the mouse
	 * position.
	 * 
	 * Use responsibly: For every MouseDown there should eventually be a
	 * corresponding MouseUp event.
	 * 
	 * @param button
	 *            see {@link #down(String)}
	 * @param x
	 *            The x coordinates to move the mouse to.
	 * @param y
	 *            The y coordinates to move the mouse to.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean down(final MouseButton button, int x, int y) {
		return down(button.getButton(), x, y);
	}

	/**
	 * Moves the mouse pointer and perform a mouse down event at the mouse
	 * position.
	 * 
	 * Use responsibly: For every MouseDown there should eventually be a
	 * corresponding MouseUp event.
	 * 
	 * @param button
	 *            see {@link #down(String)}
	 * @param x
	 *            The x coordinates to move the mouse to.
	 * @param y
	 *            The y coordinates to move the mouse to.
	 * @param speed
	 *            the speed to move the mouse in the range 1 (fastest) to 100
	 *            (slowest). A speed of 0 will move the mouse instantly. Default
	 *            speed is 10.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean down(final MouseButton button, int x, int y, int speed) {
		return down(button.getButton(), x, y, speed);
	}

	/**
	 * Moves the mouse pointer and perform a mouse down event at the mouse
	 * position.
	 * 
	 * Use responsibly: For every MouseDown there should eventually be a
	 * corresponding MouseUp event.
	 * 
	 * @param button
	 *            The button to click: "left", "right", "middle", "main",
	 *            "menu", "primary", "secondary".
	 * @param x
	 *            The x coordinates to move the mouse to.
	 * @param y
	 *            The y coordinates to move the mouse to.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean down(final String button, int x, int y) {
		move(x, y);
		return down(button);
	}

	/**
	 * Moves the mouse pointer and perform a mouse down event at the mouse
	 * position.
	 * 
	 * Use responsibly: For every MouseDown there should eventually be a
	 * corresponding MouseUp event.
	 * 
	 * @param button
	 *            The button to click: "left", "right", "middle", "main",
	 *            "menu", "primary", "secondary".
	 * @param x
	 *            The x coordinates to move the mouse to.
	 * @param y
	 *            The y coordinates to move the mouse to.
	 * @param speed
	 *            the speed to move the mouse in the range 1 (fastest) to 100
	 *            (slowest). A speed of 0 will move the mouse instantly. Default
	 *            speed is 10.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean down(final String button, int x, int y, int speed) {
		move(x, y, speed);
		return down(button);
	}

	/**
	 * Returns a cursor ID Number of the current Mouse Cursor.
	 * 
	 * @return Returns a cursor ID Number:<br>
	 *         0 = UNKNOWN (this includes pointing and grabbing hand icons)<br>
	 *         1 = APPSTARTING<br>
	 *         2 = ARROW<br>
	 *         3 = CROSS<br>
	 *         4 = HELP<br>
	 *         5 = IBEAM<br>
	 *         6 = ICON<br>
	 *         7 = NO<br>
	 *         8 = SIZE<br>
	 *         9 = SIZEALL<br>
	 *         10 = SIZENESW<br>
	 *         11 = SIZENS<br>
	 *         12 = SIZENWSE<br>
	 *         13 = SIZEWE<br>
	 *         14 = UPARROW<br>
	 *         15 = WAIT
	 */
	public MouseCursor getCursor() {
		MouseCursor mouseCursor = null;
		final int cursorId = AutoItXImpl.autoItX.AU3_MouseGetCursor();
		for (MouseCursor cursor : MouseCursor.values()) {
			if (cursor.getId() == cursorId) {
				mouseCursor = cursor;
				break;
			}
		}

		return mouseCursor;
	}

	/**
	 * Retrieves the current position of the mouse cursor.
	 * 
	 * See MouseCoordMode for relative/absolute position settings. If relative
	 * positioning, numbers may be negative.
	 * 
	 * @return Returns the current position of the mouse cursor.
	 */
	public int[] getPos() {
		POINT point = new POINT();
		AutoItXImpl.autoItX.AU3_MouseGetPos(point);
		return new int[] { point.x, point.y };
	}

	/**
	 * Retrieves the current X position of the mouse cursor.
	 * 
	 * See MouseCoordMode for relative/absolute position settings. If relative
	 * positioning, numbers may be negative.
	 * 
	 * @return Returns the current X position of the mouse cursor.
	 */
	public int getPosX() {
		return getPos()[0];
	}

	/**
	 * Retrieves the current Y position of the mouse cursor.
	 * 
	 * See MouseCoordMode for relative/absolute position settings. If relative
	 * positioning, numbers may be negative.
	 * 
	 * @return Returns the current Y position of the mouse cursor.
	 */
	public int getPosY() {
		return getPos()[1];
	}

	/**
	 * Moves the mouse pointer.
	 * 
	 * @param x
	 *            The screen x coordinate to move the mouse to.
	 * @param y
	 *            The screen y coordinate to move the mouse to.
	 * @return User mouse movement is hindered during a non-instantaneous
	 *         MouseMove operation. If MouseCoordMode is relative positioning,
	 *         numbers may be negative.
	 */
	public int move(final int x, final int y) {
		return move(x, y, null);
	}

	/**
	 * Moves the mouse pointer.
	 * 
	 * @param x
	 *            The screen x coordinate to move the mouse to.
	 * @param y
	 *            The screen y coordinate to move the mouse to.
	 * @param speed
	 *            the speed to move the mouse in the range 1 (fastest) to 100
	 *            (slowest). A speed of 0 will move the mouse instantly. Default
	 *            speed is 10.
	 * @return User mouse movement is hindered during a non-instantaneous
	 *         MouseMove operation. If MouseCoordMode is relative positioning,
	 *         numbers may be negative.
	 */
	public int move(final int x, final int y, final Integer speed) {
		return AutoItXImpl.autoItX.AU3_MouseMove(x, y, speed);
	}

	/**
	 * Perform a mouse up event at the current mouse position.
	 * 
	 * Use responsibly: For every MouseDown there should eventually be a
	 * corresponding MouseUp event.
	 * 
	 * @param button
	 *            see {@link #up(String)}
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean up(final MouseButton button) {
		return up(button.getButton());
	}

	/**
	 * Perform a mouse up event at the current mouse position.
	 * 
	 * Use responsibly: For every MouseDown there should eventually be a
	 * corresponding MouseUp event.
	 * 
	 * @param button
	 *            The button to click: "left", "right", "middle", "main",
	 *            "menu", "primary", "secondary".
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean up(final String button) {
		if (!checkMouseButton(button)) {
			return false;
		}
		AutoItXImpl.autoItX.AU3_MouseUp(AutoItUtils.stringToWString(button));
		return !LocalInstances.autoItX.hasError();
	}

	/**
	 * Moves the mouse wheel up or down. NT/2000/XP ONLY.
	 * 
	 * This function only works on NT, 2000, XP and later operating systems.
	 * 
	 * @param direction
	 *            "up" or "down"
	 */
	public void wheel(final MouseWheelDirection direction) {
		wheel(direction.getDirection());
	}

	/**
	 * Moves the mouse wheel up or down. NT/2000/XP ONLY.
	 * 
	 * This function only works on NT, 2000, XP and later operating systems.
	 * 
	 * @param direction
	 *            "up" or "down"
	 * @return Return false if the direction is not recognized, otherwise return
	 *         true.
	 */
	public boolean wheel(final String direction) {
		return wheel(direction, null);
	}

	/**
	 * Moves the mouse wheel up or down. NT/2000/XP ONLY.
	 * 
	 * This function only works on NT, 2000, XP and later operating systems.
	 * 
	 * @param direction
	 *            see {@link #wheel(String, Integer)}
	 * @param clicks
	 *            The number of times to move the wheel. Default is 1.
	 */
	public void wheel(final MouseWheelDirection direction,
			final Integer clicks) {
		wheel(direction.getDirection(), clicks);
	}

	/**
	 * Moves the mouse wheel up or down. NT/2000/XP ONLY.
	 * 
	 * This function only works on NT, 2000, XP and later operating systems.
	 * 
	 * @param direction
	 *            "up" or "down"
	 * @param clicks
	 *            The number of times to move the wheel. Default is 1.
	 * @return Return false if the direction is not recognized, otherwise return
	 *         true.
	 */
	public boolean wheel(final String direction, final Integer clicks) {
		if (!MOUSE_WHEEL_DIRECTION_UP.equalsIgnoreCase(direction)
				&& !MOUSE_WHEEL_DIRECTION_DOWN.equalsIgnoreCase(direction)) {
			return false;
		}

		AutoItXImpl.autoItX.AU3_MouseWheel(
				AutoItUtils.stringToWString(AutoItUtils.defaultString(direction.toLowerCase())),
				(clicks == null) ? 1 : clicks);
		return !LocalInstances.autoItX.hasError();
	}

	private static boolean checkMouseButton(String button) {
		boolean validButton = false;
		if (StringUtils.isEmpty(button)) {
			validButton = true;
		} else {
			for (MouseButton mouseButton : MouseButton.values()) {
				if (mouseButton.getButton().equalsIgnoreCase(button)) {
					validButton = true;
					break;
				}
			}
		}
		return validButton;
	}

	}
