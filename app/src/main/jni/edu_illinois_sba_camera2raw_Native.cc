#include <iostream>
#include <fstream>
#include "edu_illinois_sba_camera2raw_Native.h"

JNIEXPORT void JNICALL Java_edu_illinois_sba_camera2raw_Native_saveImageAsCSV
  (JNIEnv *env, jclass, jstring jstr, jobject jobj, jint width, jint height) {
	short *buf = (short *) env->GetDirectBufferAddress(jobj);
	const char *path = env->GetStringUTFChars(jstr, nullptr);
	std::ofstream output(path);
	for (int i = 0; i < height; ++i) {
		for (int j = 0; j < width; ++j) {
			output << *(buf++) << ",";
		}
		output << "\n";
	}
	output.close();
	env->ReleaseStringUTFChars(jstr, path);
}
  
JNIEXPORT void JNICALL Java_edu_illinois_sba_camera2raw_Native_saveImageAsBin
  (JNIEnv *env, jclass, jstring jstr, jobject jobj, jint width, jint height, 
  jint top, jint bottom, jint left, jint right) {
	short *buf = (short *) env->GetDirectBufferAddress(jobj);
	const char *path = env->GetStringUTFChars(jstr, nullptr);
	std::ofstream output(path, std::ofstream::binary);
	output.write((char *)&top, sizeof(int));
	output.write((char *)&bottom, sizeof(int));
	output.write((char *)&left, sizeof(int));
	output.write((char *)&right, sizeof(int));
	output.write((char *)buf, sizeof(short) * width * height);
	output.close();
	env->ReleaseStringUTFChars(jstr, path); 
  }

