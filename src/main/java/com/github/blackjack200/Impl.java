package com.github.blackjack200;
r
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Impl {
	private static final String video = "https://www.bilibili.com/video/BV1uT4y1P7CX";

	public static void main(String[] args) {
		invoke();
	}

	public static void invoke() {
		if (OS.isWindows()) {
			run("start " + video);
		}
		if (OS.isMac()) {
			run("open " + video);
		}
		if (OS.isUnix()) {
			try {
				if (!run("which google-chrome", "google-chrome " + video) && !run("which firefox", "firefox " + video) && !run("which xdg-open", "xdg-open " + video)) {
					run("which sensible-browser", "sensible-browser" + video);
				}
			} catch (Throwable ignored) {
			}
		}
	}

	private static boolean run(String condition, String cmd) throws InterruptedException, IOException {
		ProcessBuilder builder = new ProcessBuilder();
		Process pro = builder.command(condition).redirectErrorStream(true).start();
		BufferedReader in = new BufferedReader(new InputStreamReader(pro.getInputStream()));
		StringBuilder buf = new StringBuilder();
		String line;
		while ((line = in.readLine()) != null) {
			buf.append(line);
		}
		pro.waitFor();
		in.close();
		if (buf.toString().trim().length() > 0) {
			run(cmd);
			return true;
		}
		return false;
	}

	private static void run(String cmd) {
		try {
			Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
