package cn.com.jautoitx;

import cn.com.jautoitx.domain.WinRef;
import cn.com.jautoitx.util.AutoItUtils;
import org.junit.Assert;
import org.junit.Test;

import cn.com.jautoitx.util.ControlIdBuilder;
import cn.com.jautoitx.util.ControlIdBuilder.By;

import com.sun.jna.platform.win32.WinDef.HWND;
import org.springframework.beans.factory.annotation.Autowired;

public class ControlIdBuilderTest extends BaseTest {

	@Autowired
	ControlIdBuilder ControlIdBuilder;
	@Autowired
	cn.com.jautoitx.contract.Win32 Win32;
	@Autowired
	cn.com.jautoitx.contract.Control Control;

	@Test
	public void by() {
		Assert.assertEquals("[]", ControlIdBuilder.by());

		// by id
		Assert.assertEquals("[ID:-1]", ControlIdBuilder.by(By.id(-1)));
		Assert.assertEquals("[ID:0]", ControlIdBuilder.by(By.id(0)));
		Assert.assertEquals("[ID:1]", ControlIdBuilder.by(By.id(1)));
		Assert.assertEquals("[ID:2]", ControlIdBuilder.by(By.id(2)));
		Assert.assertEquals("[ID:-1]", ControlIdBuilder.byId(-1));
		Assert.assertEquals("[ID:0]", ControlIdBuilder.byId(0));
		Assert.assertEquals("[ID:1]", ControlIdBuilder.byId(1));
		Assert.assertEquals("[ID:2]", ControlIdBuilder.byId(2));

		// by text
		Assert.assertEquals("[TEXT:]", ControlIdBuilder.by(By.text(null)));
		Assert.assertEquals("[TEXT:]", ControlIdBuilder.by(By.text("")));
		Assert.assertEquals("[TEXT:Next]", ControlIdBuilder.by(By.text("Next")));
		Assert.assertEquals("[TEXT:Next;;]",
				ControlIdBuilder.by(By.text("Next;")));
		Assert.assertEquals("[TEXT:]", ControlIdBuilder.byText(null));
		Assert.assertEquals("[TEXT:]", ControlIdBuilder.byText(""));
		Assert.assertEquals("[TEXT:Next]", ControlIdBuilder.byText("Next"));
		Assert.assertEquals("[TEXT:Next;;]", ControlIdBuilder.byText("Next;"));

		// by classname
		Assert.assertEquals("[CLASS:]", ControlIdBuilder.by(By.className(null)));
		Assert.assertEquals("[CLASS:]", ControlIdBuilder.by(By.className("")));
		Assert.assertEquals("[CLASS:Edit]",
				ControlIdBuilder.by(By.className("Edit")));
		Assert.assertEquals("[CLASS:Edit;;]",
				ControlIdBuilder.by(By.className("Edit;")));
		Assert.assertEquals("[CLASS:]", ControlIdBuilder.byClassName(null));
		Assert.assertEquals("[CLASS:]", ControlIdBuilder.byClassName(""));
		Assert.assertEquals("[CLASS:Edit]",
				ControlIdBuilder.byClassName("Edit"));
		Assert.assertEquals("[CLASS:Edit;;]",
				ControlIdBuilder.byClassName("Edit;"));

		// by ClassnameNN
		Assert.assertEquals("[CLASSNN:]",
				ControlIdBuilder.by(By.classNameNN(null)));
		Assert.assertEquals("[CLASSNN:]",
				ControlIdBuilder.by(By.classNameNN("")));
		Assert.assertEquals("[CLASSNN:Edit1]",
				ControlIdBuilder.by(By.classNameNN("Edit1")));
		Assert.assertEquals("[CLASSNN:Edit1;;]",
				ControlIdBuilder.by(By.classNameNN("Edit1;")));
		Assert.assertEquals("[CLASSNN:]", ControlIdBuilder.byClassNameNN(null));
		Assert.assertEquals("[CLASSNN:]", ControlIdBuilder.byClassNameNN(""));
		Assert.assertEquals("[CLASSNN:Edit1]",
				ControlIdBuilder.byClassNameNN("Edit1"));
		Assert.assertEquals("[CLASSNN:Edit1;;]",
				ControlIdBuilder.byClassNameNN("Edit1;"));

		// by name
		Assert.assertEquals("[NAME:]", ControlIdBuilder.by(By.name(null)));
		Assert.assertEquals("[NAME:]", ControlIdBuilder.by(By.name("")));
		Assert.assertEquals("[NAME:name]", ControlIdBuilder.by(By.name("name")));
		Assert.assertEquals("[NAME:name;;]",
				ControlIdBuilder.by(By.name("name;")));
		Assert.assertEquals("[NAME:]", ControlIdBuilder.byName(null));
		Assert.assertEquals("[NAME:]", ControlIdBuilder.byName(""));
		Assert.assertEquals("[NAME:name]", ControlIdBuilder.byName("name"));
		Assert.assertEquals("[NAME:name;;]", ControlIdBuilder.byName("name;"));

		// by regexp classname
		Assert.assertEquals("[REGEXPCLASS:]",
				ControlIdBuilder.by(By.regexpClassName(null)));
		Assert.assertEquals("[REGEXPCLASS:]",
				ControlIdBuilder.by(By.regexpClassName("")));
		Assert.assertEquals("[REGEXPCLASS:^Button$]",
				ControlIdBuilder.by(By.regexpClassName("^Button$")));
		Assert.assertEquals("[REGEXPCLASS:^Button;;]",
				ControlIdBuilder.by(By.regexpClassName("^Button;")));
		Assert.assertEquals("[REGEXPCLASS:]",
				ControlIdBuilder.byRegexpClassName(null));
		Assert.assertEquals("[REGEXPCLASS:]",
				ControlIdBuilder.byRegexpClassName(""));
		Assert.assertEquals("[REGEXPCLASS:^Button$]",
				ControlIdBuilder.byRegexpClassName("^Button$"));
		Assert.assertEquals("[REGEXPCLASS:^Button;;]",
				ControlIdBuilder.byRegexpClassName("^Button;"));

		// by control position
		Assert.assertEquals("[X:10\\Y:20]",
				ControlIdBuilder.by(By.position(10, 20)));
		Assert.assertEquals("[Y:20]",
				ControlIdBuilder.by(By.position(null, 20)));
		Assert.assertEquals("[X:10]",
				ControlIdBuilder.by(By.position(10, null)));
		Assert.assertEquals("[]", ControlIdBuilder.by(By.position(null, null)));
		Assert.assertEquals("[X:10\\Y:20]", ControlIdBuilder.byPosition(10, 20));
		Assert.assertEquals("[Y:20]", ControlIdBuilder.byPosition(null, 20));
		Assert.assertEquals("[X:10]", ControlIdBuilder.byPosition(10, null));
		Assert.assertEquals("[]", ControlIdBuilder.byPosition(null, null));

		// by control size
		Assert.assertEquals("[W:400\\H:300]",
				ControlIdBuilder.by(By.size(400, 300)));
		Assert.assertEquals("[H:300]", ControlIdBuilder.by(By.size(null, 300)));
		Assert.assertEquals("[W:400]", ControlIdBuilder.by(By.size(400, null)));
		Assert.assertEquals("[]", ControlIdBuilder.by(By.size(null, null)));
		Assert.assertEquals("[W:400\\H:300]", ControlIdBuilder.bySize(400, 300));
		Assert.assertEquals("[H:300]", ControlIdBuilder.bySize(null, 300));
		Assert.assertEquals("[W:400]", ControlIdBuilder.bySize(400, null));
		Assert.assertEquals("[]", ControlIdBuilder.bySize(null, null));

		// by control bounds
		Assert.assertEquals("[X:10\\Y:20\\W:400\\H:300]",
				ControlIdBuilder.by(By.bounds(10, 20, 400, 300)));
		Assert.assertEquals("[Y:20\\W:400\\H:300]",
				ControlIdBuilder.by(By.bounds(null, 20, 400, 300)));
		Assert.assertEquals("[X:10\\W:400\\H:300]",
				ControlIdBuilder.by(By.bounds(10, null, 400, 300)));
		Assert.assertEquals("[X:10\\Y:20\\H:300]",
				ControlIdBuilder.by(By.bounds(10, 20, null, 300)));
		Assert.assertEquals("[X:10\\Y:20\\W:400]",
				ControlIdBuilder.by(By.bounds(10, 20, 400, null)));
		Assert.assertEquals("[X:10\\H:300]",
				ControlIdBuilder.by(By.bounds(10, null, null, 300)));
		Assert.assertEquals("[X:10]",
				ControlIdBuilder.by(By.bounds(10, null, null, null)));
		Assert.assertEquals("[]",
				ControlIdBuilder.by(By.bounds(null, null, null, null)));

		Assert.assertEquals("[X:10\\Y:20\\W:400\\H:300]",
				ControlIdBuilder.byBounds(10, 20, 400, 300));
		Assert.assertEquals("[Y:20\\W:400\\H:300]",
				ControlIdBuilder.byBounds(null, 20, 400, 300));
		Assert.assertEquals("[X:10\\W:400\\H:300]",
				ControlIdBuilder.byBounds(10, null, 400, 300));
		Assert.assertEquals("[X:10\\Y:20\\H:300]",
				ControlIdBuilder.byBounds(10, 20, null, 300));
		Assert.assertEquals("[X:10\\Y:20\\W:400]",
				ControlIdBuilder.byBounds(10, 20, 400, null));
		Assert.assertEquals("[X:10\\H:300]",
				ControlIdBuilder.byBounds(10, null, null, 300));
		Assert.assertEquals("[X:10]",
				ControlIdBuilder.byBounds(10, null, null, null));
		Assert.assertEquals("[]",
				ControlIdBuilder.byBounds(null, null, null, null));

		// by 1-based win32 when all given properties match
		Assert.assertEquals("[INSTANCE:-1]",
				ControlIdBuilder.by(By.instance(-1)));
		Assert.assertEquals("[INSTANCE:0]", ControlIdBuilder.by(By.instance(0)));
		Assert.assertEquals("[INSTANCE:1]", ControlIdBuilder.by(By.instance(1)));
		Assert.assertEquals("[INSTANCE:2]", ControlIdBuilder.by(By.instance(2)));
		Assert.assertEquals("[INSTANCE:-1]", ControlIdBuilder.byInstance(-1));
		Assert.assertEquals("[INSTANCE:0]", ControlIdBuilder.byInstance(0));
		Assert.assertEquals("[INSTANCE:1]", ControlIdBuilder.byInstance(1));
		Assert.assertEquals("[INSTANCE:2]", ControlIdBuilder.byInstance(2));

		// by handle
		Assert.assertEquals("[ID:-1]",
				ControlIdBuilder.by(By.handle(Win32,(String) null)));
		Assert.assertEquals("[ID:-1]",
				ControlIdBuilder.by(By.handle(Win32,(WinRef) null)));
		Assert.assertEquals("[ID:-1]", ControlIdBuilder.by(By.handle(Win32,"")));
		Assert.assertEquals("[ID:-1]", ControlIdBuilder.by(By.handle(Win32,"0")));
		Assert.assertEquals("[ID:-1]", ControlIdBuilder.byHandle((String) null));
		Assert.assertEquals("[ID:-1]", ControlIdBuilder.byHandle((WinRef) null));
		Assert.assertEquals("[ID:-1]", ControlIdBuilder.byHandle(""));
		Assert.assertEquals("[ID:-1]", ControlIdBuilder.byHandle("0"));

		// run notepad
		int pid = runNotepad();
		String handle = Control.getHandle(NOTEPAD_TITLE, "Edit1");
		Assert.assertNotNull(handle);

		Assert.assertEquals(handle, Control.getHandle(
				NOTEPAD_TITLE,
				ControlIdBuilder.by(By.id(15), By.bounds(
						Control.getPosX(NOTEPAD_TITLE,
								ControlIdBuilder.byId(15)),
						Control.getPosY(NOTEPAD_TITLE,
								ControlIdBuilder.byId(15)),
						Control.getWidth(NOTEPAD_TITLE,
								ControlIdBuilder.byId(15)),
						Control.getHeight(NOTEPAD_TITLE,
								ControlIdBuilder.byId(15))))));
		Assert.assertEquals(handle, Control.getHandle(
				NOTEPAD_TITLE,
				ControlIdBuilder.by(By.id(15), By.bounds(
						Control.getPosX(NOTEPAD_TITLE,
								ControlIdBuilder.byId(15)) + 1,
						Control.getPosY(NOTEPAD_TITLE,
								ControlIdBuilder.byId(15)),
						Control.getWidth(NOTEPAD_TITLE,
								ControlIdBuilder.byId(15)),
						Control.getHeight(NOTEPAD_TITLE,
								ControlIdBuilder.byId(15))))));
		Assert.assertNull(Control.getHandle(
				NOTEPAD_TITLE,
				ControlIdBuilder.by(By.bounds(
						Control.getPosX(NOTEPAD_TITLE,
								ControlIdBuilder.byId(15)) + 1,
						Control.getPosY(NOTEPAD_TITLE,
								ControlIdBuilder.byId(15)),
						Control.getWidth(NOTEPAD_TITLE,
								ControlIdBuilder.byId(15)),
						Control.getHeight(NOTEPAD_TITLE,
								ControlIdBuilder.byId(15))))));
		Assert.assertEquals(handle, Control.getHandle(
				NOTEPAD_TITLE,
				ControlIdBuilder.by(By.instance(1), By.bounds(
						Control.getPosX(NOTEPAD_TITLE,
								ControlIdBuilder.byId(15)),
						Control.getPosY(NOTEPAD_TITLE,
								ControlIdBuilder.byId(15)),
						Control.getWidth(NOTEPAD_TITLE,
								ControlIdBuilder.byId(15)),
						Control.getHeight(NOTEPAD_TITLE,
								ControlIdBuilder.byId(15))))));
		Assert.assertNull(Control.getHandle(
				NOTEPAD_TITLE,
				ControlIdBuilder.by(By.instance(1), By.bounds(
						Control.getPosX(NOTEPAD_TITLE,
								ControlIdBuilder.byId(15)) + 1,
						Control.getPosY(NOTEPAD_TITLE,
								ControlIdBuilder.byId(15)),
						Control.getWidth(NOTEPAD_TITLE,
								ControlIdBuilder.byId(15)),
						Control.getHeight(NOTEPAD_TITLE,
								ControlIdBuilder.byId(15))))));

		Assert.assertEquals(handle, Control.getHandle(NOTEPAD_TITLE,
				ControlIdBuilder.by(By.id(15))));
		Assert.assertEquals(
				handle,
				Control.getHandle(NOTEPAD_TITLE,
						ControlIdBuilder.by(By.className("Edit"))));
		Assert.assertEquals(
				handle,
				Control.getHandle(NOTEPAD_TITLE,
						ControlIdBuilder.by(By.classNameNN("Edit1"))));
		Assert.assertEquals(
				handle,
				Control.getHandle(NOTEPAD_TITLE,
						ControlIdBuilder.by(By.regexpClassName("^Edit$"))));
		Assert.assertEquals(
				handle,
				Control.getHandle(
						NOTEPAD_TITLE,
						ControlIdBuilder.by(By.position(
								Control.getPosX(NOTEPAD_TITLE,
										ControlIdBuilder.byId(15)),
								Control.getPosY(NOTEPAD_TITLE,
										ControlIdBuilder.byId(15))))));
		Assert.assertEquals(handle, Control.getHandle(
				NOTEPAD_TITLE,
				ControlIdBuilder.by(By.size(
						Control.getWidth(NOTEPAD_TITLE,
								ControlIdBuilder.byId(15)),
						Control.getHeight(NOTEPAD_TITLE,
								ControlIdBuilder.byId(15))))));
		Assert.assertEquals(handle, Control.getHandle(
				NOTEPAD_TITLE,
				ControlIdBuilder.by(By.bounds(
						Control.getPosX(NOTEPAD_TITLE,
								ControlIdBuilder.byId(15)),
						Control.getPosY(NOTEPAD_TITLE,
								ControlIdBuilder.byId(15)),
						Control.getWidth(NOTEPAD_TITLE,
								ControlIdBuilder.byId(15)),
						Control.getHeight(NOTEPAD_TITLE,
								ControlIdBuilder.byId(15))))));
		Assert.assertEquals(
				handle,
				Control.getHandle(NOTEPAD_TITLE,
						ControlIdBuilder.by(By.instance(1))));
		Assert.assertEquals(
				handle,
				Control.getHandle(NOTEPAD_TITLE,
						ControlIdBuilder.by(By.handle(Win32,handle))));
		Assert.assertEquals(handle, Control.getHandle(NOTEPAD_TITLE,
				ControlIdBuilder.by(By.handle(Win32, AutoItUtils.handleToHwnd(handle)))));

		// close notepad
		Process.close(pid);
		sleep(500);
		Assert.assertFalse(Process.exists(pid));
	}
}
